/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import model.User;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import repository.UserRepository;
import repository.impl.UserRepositoryImpl;
/**
 *
 * @author script-dark
 */
@ManagedBean(name = "myBean")
@RequestScoped
public class test implements Serializable{
    public List<User> user;
    
    private ApplicationContext ctx=null;
    private DataSource datasource = null;
    private JdbcTemplate template = null;
    private SimpleJdbcInsert jdbcInsert = null;
   
    /**
     * Creates a new instance of test
     */
   
    public test() {
        
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        user = ctx.getBean("UserRepositoryImpl", UserRepository.class).getAll();
//        template = new JdbcTemplate(datasource);
        
    }
    
     public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
    
}
