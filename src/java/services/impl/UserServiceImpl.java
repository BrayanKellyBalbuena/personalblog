/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import model.User;
import java.util.List;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import services.UserService;

/**
 *
 * @author script-dark
 */
@Service
public class UserServiceImpl implements UserService{
    
    private UserRepository repository;
            
    public UserServiceImpl(UserRepository repository){
    
    this.repository = repository;
            
    }
    
    @Override
    public void save(User entity) {
        repository.save(entity);
    }

    @Override
    public User update(User entity) {
        repository.update(entity);
        return null;
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public User findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAll() {
       return repository.getAll();
    }
    
    
    
}
