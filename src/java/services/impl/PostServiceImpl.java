/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.util.List;
import model.Post;
import repository.PostRepository;
import services.PostService;

/**
 *
 * @author script-dark
 */
public class PostServiceImpl implements PostService{
    
     private PostRepository repository;
            
    public PostServiceImpl(PostRepository repository){
        this.repository = repository;
    }
    @Override
    public void save(Post entity) {
        repository.save(entity);
    }

    @Override
    public Post update(Post entity) {
            repository.update(entity);
        return null;
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public Post findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public List<Post> getAll() {
        return repository.getAll();
    }

    @Override
    public List<Post> findByAuthorId(Integer autor_id) {
       return repository.findByAuthorId(autor_id);
    }
    
}
