package com.codeup.blog;

public class Post {
    private long id;
    public String title;
    public String description;
    public String body;


    public Post() {};

    public Post(long id, String title, String description, String body) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
}