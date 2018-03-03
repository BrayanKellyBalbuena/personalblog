/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author script-dark
 */
public class Post {
    private int postId;
    private int autorId;
    private String autorName;
    private LocalDateTime createdDate;
    private String title;
    private String content;
    
    public Post(){}
    
    public Post(String title, String content){
        this.title = title;
        this.content = content;
        this.createdDate = LocalDateTime.now();
    }

    public Post(int postId ,int autorId, LocalDateTime createdDate, String title,
            String contenido) {
        this.postId = postId;
        this.autorId = autorId;
        this.createdDate = LocalDateTime.now();
        this.title = title;
        this.content = contenido;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
    
    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }
    
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String contenido) {
        this.content = contenido;
    }    
    
}


