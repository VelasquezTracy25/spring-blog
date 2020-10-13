package com.codeup.blog;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 500)
    public String title;

    @Column(nullable = false)
    public String description;

    @Column(nullable = false)
    public String body;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public String date;
    public String slug;

    public Post() {};

    public Post(long id, String date, String title, String description, String body, String slug) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.body = body;
        this.slug = slug;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}