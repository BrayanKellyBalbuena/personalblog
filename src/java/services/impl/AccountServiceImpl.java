/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import com.sun.istack.internal.logging.Logger;
import model.User;
import enums.LoginStatusEnum;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import org.springframework.dao.EmptyResultDataAccessException;
import repository.UserRepository;
import services.AccountService;
import utils.UserAccountStatus;

/**
 *
 * @author script-dark
 */
public class AccountServiceImpl implements AccountService<User> {

    User user = null;
    private UserRepository repository = null;
    private Logger logger = Logger.getLogger(AccountServiceImpl.class);
    private User tempUser;

    public AccountServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public LoginStatusEnum Login(User user) {
         Map<LoginStatusEnum,User> e;
        e = new HashMap<>();
        UserAccountStatus s = new UserAccountStatus(tempUser, LoginStatusEnum.FOUND);
        e.put(LoginStatusEnum.FOUND, tempUser);
       
        if (!isUserExist(user.getEmail())) {
            return LoginStatusEnum.NOT_FOUND;
        } else if (tempUser.getUserPassword().equals(user.getUserPassword())) {
               
            return LoginStatusEnum.SUCCESS;
        }
        return LoginStatusEnum.BAD_REQUEST;
    }
    
      
    public UserAccountStatus Login2(User user) {
         
        UserAccountStatus userAccountStatus = 
                new UserAccountStatus(LoginStatusEnum.BAD_REQUEST);
       
        if (!isUserExist(user.getEmail())) {
                userAccountStatus.setLoginStatusEnum(LoginStatusEnum.NOT_FOUND);
            return userAccountStatus;
            
        } else if (tempUser.getUserPassword().equals(user.getUserPassword())) {
           userAccountStatus.setUser(tempUser);
           userAccountStatus.setLoginStatusEnum(LoginStatusEnum.SUCCESS);
           
           return userAccountStatus;
        }
        return userAccountStatus;
    }

    private Boolean isUserExist(String email) {
        try  {
            tempUser = repository.findByEmail(email);
            if (tempUser == null) {
                logger.log(Level.INFO, "user with email: " + email + "found!" );
                return false;
            }
        }catch(EmptyResultDataAccessException e){
            logger.log(Level.INFO, "user with email: " + email + " not found!");
             return false;
        }
        return true;
    }

    @Override
    public LoginStatusEnum Register(User user) {
        if (isUserExist(user.getEmail())) {
            return LoginStatusEnum.FOUND;
        } else {
            try {
                repository.save(user);
                return LoginStatusEnum.SUCCESS;
            } catch (Exception e) {
                logger.log(Level.SEVERE, e.getMessage(), e.getStackTrace().toString());
                return LoginStatusEnum.INTERNAL_ERROR;
                
            }
        }
    }

}
