package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String getPosts() {
        return "This will return all posts.";
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseBody
    public String getPostsById(@PathVariable int id) {
        return "This will return all posts with the id of " + id + ".";
    }

    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "This will return the form for creating a post.";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost() {
        return "This will create a new post once form is submitted.";
    }


}
