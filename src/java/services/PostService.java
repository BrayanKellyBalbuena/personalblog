/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.Post;

/**
 *
 * @author script-dark
 */
public interface PostService extends GenericRepositoryService<Post, Integer>{
     List<Post> findByAuthorId(Integer autor_id);
}
