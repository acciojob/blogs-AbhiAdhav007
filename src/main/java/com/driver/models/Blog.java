package com.driver.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog_db")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    @CreationTimestamp
    private Date postedDate;

    // blog is child for user  so i have to join the colum to user with there primary ky
    @ManyToOne
    @JoinColumn
    private User user;

    // Blogs is parent for Image because i can post Blog without Image so that why;
    @OneToMany
    private List<Image>blogImages=new ArrayList<>();





    public Blog() {
    }

    public List<Image> getBlogImages() {
        return blogImages;
    }

    public void setBlogImages(List<Image> blogImages) {
        this.blogImages = blogImages;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }
}