/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import model.Post;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.PostService;

/**
 *
 * @author script-dark
 */
@ManagedBean(name="posts")
@RequestScoped
public class PostManagedBean {
    private Post tempPost;
    private final ClassPathXmlApplicationContext ctx;
    private final PostService service;
    private List<Post> posts;

    public Post getTempPost() {
        return tempPost;
    }

    public void setTempPost(Post tempPost) {
        this.tempPost = tempPost;
    }
    
    public PostManagedBean() {
         ctx      = new ClassPathXmlApplicationContext("applicationContext.xml");
         service  = ctx.getBean("PostServiceImpl", PostService.class);
         tempPost = new Post("","");
    }
    
    public String save(int authorId){
        if(tempPost.getPostId() != 0)
        {
            service.update(tempPost);
        }else{
            tempPost.setAutorId(authorId);
            service.save(tempPost);
        }
        clearTempPostAttributes();
        return null;
    }
    
     private void clearTempPostAttributes()
    {
        tempPost.setContent("");
        tempPost.setTitle("");
    }
    
    public String update(int postId){
        tempPost = service.findById(postId);
        return "post";
    }
    
    public String delete(int postId){
        service.delete(postId);
        return "user_post";
    }
    
    public List<Post> getPosts() {
        return service.getAll();
    }
    
     public List<Post>getAutorPost(int autorId){
        return  service.findByAuthorId(autorId);
    }

    public void setPost(List<Post> posts) {
        this.posts = posts;
    }
    
   
    
  
    
}
