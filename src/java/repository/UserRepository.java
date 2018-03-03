/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.User;

/**
 *
 * @author script-dark
 */
public interface UserRepository extends GenericRepository<User, Integer> {
    User findByEmail(String email);
}
