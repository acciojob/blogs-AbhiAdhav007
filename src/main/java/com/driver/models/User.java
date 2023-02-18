package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String passWord;

    private String firstName;
    private String lastName;

    // mapping blog with user
    // user is parent for blogs
    // threr remation is one to many why?because user can post multipal blogs;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Blog>postedBlogs=new ArrayList<>();








    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getPostedBlogs() {
        return postedBlogs;
    }

    public void setPostedBlogs(List<Blog> postedBlogs) {
        this.postedBlogs = postedBlogs;
    }
}