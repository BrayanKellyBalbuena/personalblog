/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import com.sun.istack.internal.logging.Logger;
import model.User;
import entityMappers.UserMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import repository.UserRepository;

/**
 *
 * @author script-dark
 */
public class UserRepositoryImpl implements UserRepository {

    JdbcTemplate template                 =   null;
    private SimpleJdbcInsert jdbcInsert   =   null;
    private final String USER_TABLE       =   "users";
    private final String SELECT_ALL       =   "select * from users";
    private final String FIND_BY_EMAIL    =   "select * from users where email = ?";
    private final String FIND_BY_ID       =   "select * from users where user_id = ?";
    private final String DELETE_BY_ID     =   "delete from user where id = ?" ;
    private final Logger logger           =   Logger.getLogger(UserRepositoryImpl.class);
    private final String UPDATE           =   "update user set user_name = ?, password = ? where user_id = ?";
    

    public UserRepositoryImpl(JdbcTemplate template, SimpleJdbcInsert jdbcInsert) {
      this.template = template;
      this.jdbcInsert = jdbcInsert.withTableName(USER_TABLE);
    } 

    @Override
    public void save(User entity) {
        Map userMap = new HashMap();
        userMap.put("email", entity.getEmail());
        userMap.put("user_name",entity.getUserName());
        userMap.put("user_password", entity.getUserPassword());
        this.jdbcInsert = jdbcInsert.withTableName(USER_TABLE);
        jdbcInsert.execute(userMap);
    }

    @Override
    public void update(User entity) {
       template.update(UPDATE, entity.getUserName(), entity.getUserPassword());
       logger.log(Level.INFO, "User with id: " + entity.getUserName() + "was update");
    }

    @Override
    public void delete(Integer id) {
      template.update(DELETE_BY_ID, id);
      logger.log(Level.INFO, "User with id: " + id + "was delete");
    }

    @Override
    public User findById(Integer id) {
        User user = template.queryForObject(FIND_BY_ID,
                new Object[]{id},
                new UserMapper());
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = template.query(SELECT_ALL, new UserMapper());
        return users;
    }

    @Override
    public User findByEmail(String email) {
       User user = template.queryForObject(FIND_BY_EMAIL,
                new Object[]{email},
                new UserMapper()
        );
        return user;
    }

}
