/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import model.User;
import enums.LoginStatusEnum;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.impl.AccountServiceImpl;
import utils.UserAccountStatus;

/**
 *
 * @author script-dark
 */
@ManagedBean(name = "account")
@SessionScoped
public class AccountManagedBean {
    
   public Boolean login;
   public User user;
   private ApplicationContext ctx = null;
   private AccountServiceImpl service = null;
   private boolean isLogged = false;
   
    /**
     * Creates a new instance of AccountManagedBean
     */
    public AccountManagedBean() {
          ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          service = ctx.getBean("AccountServiceImpl", AccountServiceImpl.class);
          user = new User("","","");
        
    }

    public String login() {
        UserAccountStatus u = service.Login2(user);
        FacesContext context = FacesContext.getCurrentInstance();
        if(u.getLoginStatusEnum() == LoginStatusEnum.SUCCESS)
        {   
            context.getExternalContext().getSessionMap().put("user", u.getUser());
            return "user_post.xhtml?faces-redirect=true";
        }else{
            return "login";
        }
        
    }
    
    public String register()
    {
        if(service.Register(user) == LoginStatusEnum.SUCCESS){
            return "index";
        }else
        {
            return "login";
        }
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    } 
    
    private void resetUser()
    {
        this.user.setEmail("");
        this.user.setUserName("");
        this.user.setUserPassword("");
    }
    
    
}
