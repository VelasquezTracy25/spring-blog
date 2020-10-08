package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
class PostController {

    private final PostRepository postDao;

    PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping(path = "/posts/show/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("post", post);
        return "/posts/show";
    }

    //new way using dependency injection
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    @GetMapping(path = "/posts/create")
    public String createPostForm(Model model) {
    model.addAttribute("post", new Post());
        return "posts/editCreateForm";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "body") String body,
            @RequestParam(name = "slug") String slug
    ) {
        Post post = new Post();
        post.setDate(date);
        post.setTitle(title);
        post.setDescription(description);
        post.setBody(body);
        post.setSlug(slug);

        // save the post
        postDao.save(post);
        return "redirect:/posts/show/";
    }

    @GetMapping(path = "/posts/${id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("post", postDao.findById(id));
        return "posts/editCreateForm";
    }

    @PostMapping(path = "/posts/${id}/edit")
    public String editPost(){

        return "redirect:/posts/show/ + ${id}";
    }

    @GetMapping(path = "/posts/${id}/delete")
    public String deletePostForm(@PathVariable long id) {
        postDao.deleteById(id);
        return "posts/editCreateForm";
    }

    @PostMapping(path = "/posts/${id}/delete")
    public String deletePostById(@PathVariable long id, Model model) {
        model.addAttribute("id", id);
        return "redirect:/delete-message";

    }

}
