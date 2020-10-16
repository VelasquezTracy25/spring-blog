package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (nullable = false, length = 250, unique = true)
    private String date;

    @Column (nullable = false, length = 250, unique = true)
    private String title;

    @Column (nullable = false, length = 500, unique = true)
    private String description;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String body;

    @Column (nullable = false, length = 500)
    private String image;

    @Column()
    private String slug;


    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    public Post(long id, String date, String title, String description, String body, String image, User owner, String slug) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.body = body;
        this.image = image;
        this.owner = owner;
        this.slug = slug;
    }

    public Post(){}

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
