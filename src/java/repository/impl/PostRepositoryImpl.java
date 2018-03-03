/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.impl;

import com.sun.istack.internal.logging.Logger;
import entityMappers.PostEditMapper;
import entityMappers.PostMapper;
import entityMappers.UserMapper;
import java.time.LocalDateTime;
import java.util.HashMap;
import model.Post;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import repository.PostRepository;
import repository.UserRepository;
import utils.DateUtil;

/**
 *
 * @author script-dark
 */
public class PostRepositoryImpl implements PostRepository{
    
     JdbcTemplate template                  =   null;
    private SimpleJdbcInsert jdbcInsert     =   null;
    private final String POST_TABLE         =   "posts";
    private final String SELECT_ALL         =   "select p.*, s.user_name from posts as p "
                                                    + "inner join users as s on p.autor_id = s.user_id ";
    private final String FIND_BY_AUTOR_ID   =   "select p.*, s.user_name from posts as p "
                                                    + "inner join users as s on p.autor_id = s.user_id "
                                                    + "where p.autor_id = ?";
    private final String FIND_BY_ID         =   "select * from posts where post_id = ?";
    private final String DELETE_BY_ID       =   "delete from posts where post_id = ?" ;
    private final Logger logger             =   Logger.getLogger(PostRepositoryImpl.class);
    private final String UPDATE             =   "update posts set title = ?, content = ? where post_id = ?";
    
    public PostRepositoryImpl(){}
    
    public PostRepositoryImpl(JdbcTemplate template, SimpleJdbcInsert jdbcInsert) {
      this.template = template;
      this.jdbcInsert = jdbcInsert.withTableName(POST_TABLE);
    }
    
    @Override
    public void save(Post entity) {
        Map postMap = new HashMap();
        postMap.put("created_date", DateUtil.localDateTimeToString(entity.getCreatedDate()));
        postMap.put("title",entity.getTitle());
        postMap.put("content", entity.getContent());
        postMap.put("autor_id", entity.getAutorId());
        this.jdbcInsert = jdbcInsert.withTableName(POST_TABLE);
        
        jdbcInsert.execute(postMap);
    }

    @Override
    public void update(Post entity) {
       template.update(UPDATE, entity.getTitle(), entity.getContent(), entity.getPostId());
       logger.log(Level.INFO, "Post with id: " + entity.getPostId()+ "was update");
    }

    @Override
    public void delete(Integer id) {
        template.update(DELETE_BY_ID, id);
        logger.log(Level.INFO, "Post with id: " + id + "was delete");
    }

    @Override
    public Post findById(Integer id) {
        Post post;
         post = (Post) template.queryForObject(FIND_BY_ID,
                new Object[]{id},
                new PostEditMapper());
      
        return post;
    }
    
    @Override
    public List<Post> getAll() {
        List<Post> post = template.query(SELECT_ALL, new PostMapper());
        
        return post;
    }

    @Override
    public List<Post> findByAuthorId(Integer autor_id) {
       List<Post> posts = template.query(FIND_BY_AUTOR_ID,
                new Object[]{autor_id},
                new PostMapper()); 
         
         return posts;
    }
}
