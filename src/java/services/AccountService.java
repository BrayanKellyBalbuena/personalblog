/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import enums.LoginStatusEnum;

/**
 *
 * @author script-dark
 */
public interface AccountService<T> {
    LoginStatusEnum Login(T user);
    LoginStatusEnum Register(T user);
}
