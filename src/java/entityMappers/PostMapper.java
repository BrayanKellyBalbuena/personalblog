/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityMappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import model.Post;
import utils.DateUtil;

/**
 *
 * @author script-dark
 */
public class PostMapper implements RowMapper{

    @Override
    public Post mapRow(ResultSet rs, int i) throws SQLException {
        Post post = new Post();
        post.setAutorId((int)rs.getInt("autor_id"));
        post.setAutorName(rs.getString("user_name"));
        post.setPostId((int)rs.getInt("post_id"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setCreatedDate(DateUtil.stringToLocalDateTime(
                rs.getString("created_date")));
        
        return post;
    }
    
}
