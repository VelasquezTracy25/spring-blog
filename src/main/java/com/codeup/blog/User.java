package com.codeup.blog;

import javax.persistence.*;
import java.util.List;

//Create a User class, with (at least) fields for id, username, email, and password.

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 500, unique = true)
    private String username;

    @Column(nullable = false, length = 500, unique = true)
    private String email;

    @Column(nullable = false, length = 500)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


//In your User and Post classes, define the post - user relationship.

//Log in to the MySQL server and verify that the generated table structure matches what you are expecting.

//Manually insert a user record in the database.

    public User() {};

    public User(long id, String username, String email, String password, List<Post> posts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        return this.passwaord = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}




