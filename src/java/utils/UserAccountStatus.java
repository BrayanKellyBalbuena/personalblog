/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import model.User;
import enums.LoginStatusEnum;

/**
 *
 * @author script-dark
 */
public class UserAccountStatus {
    private User user;
    private LoginStatusEnum loginStatusEnum;

    public UserAccountStatus() {
    }
    
    
    public UserAccountStatus(LoginStatusEnum loginStatusEnum){
        this.loginStatusEnum = loginStatusEnum;
    }
    
    public UserAccountStatus(User user, LoginStatusEnum loginStatusEnum) {
        this.user = user;
        this.loginStatusEnum = loginStatusEnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LoginStatusEnum getLoginStatusEnum() {
        return loginStatusEnum;
    }

    public void setLoginStatusEnum(LoginStatusEnum loginStatusEnum) {
        this.loginStatusEnum = loginStatusEnum;
    }
    
    
    
}
