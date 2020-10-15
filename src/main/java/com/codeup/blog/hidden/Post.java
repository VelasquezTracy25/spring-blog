package com.codeup.blog.hidden;

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

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    public String body;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    public String date;
    public String slug;

    public Post() {};

    public Post(long id, String date, String title, String description, String body, String slug, User owner) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.body = body;
        this.slug = slug;
        this.owner = owner;
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}