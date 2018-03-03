/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import model.Post;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.PostService;
import services.impl.AccountServiceImpl;

/**
 *
 * @author script-dark
 */
@ManagedBean(name="blog")
@ViewScoped
public class BlogManagedBean {
    
   @ManagedProperty(value="#{account}")
    private AccountManagedBean account;
    
   
    private List<Post> post;
    private Post select;
    private final ClassPathXmlApplicationContext ctx;
    private final PostService service;

    public BlogManagedBean() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          service = ctx.getBean("PostServiceImpl", PostService.class);
    }
    
    public AccountManagedBean getAccount(){
        return account;
    }
    
    public void setAccount(AccountManagedBean account){
        this.account = account;
    }

    public List<Post> getPost() {
        return service.getAll();
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
    
    public List<Post>getAutorPost(int autorId){
        return  service.findByAuthorId(autorId);
    }

    public Post getSelect() {
        return select;
    }

    public void setSelect(Post select) {
        this.select = select;
    }
    
    
}
