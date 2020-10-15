package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

public class PostController {

    @Controller
    class HelloController {

        @GetMapping("/posts")
        public String index() {
            return "Return all posts";
        }

        @GetMapping("/posts/{id}")
        public String getPostById(@PathVariable long id) {
            return "Hello from Spring!";
        }

        @GetMapping("/posts/create")
        public String createPostForm() {
            return "Hello from Spring!";
        }

        @PostMapping("/posts/create")
        public String createPost(){
            return "!";
        }
    }


}
