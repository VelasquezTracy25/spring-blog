package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.repositories.UserRepository;
import com.codeup.blog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    //new way using dependency injection
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "/posts/index";
    }

    @GetMapping("/posts/show/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        model.addAttribute("user", userDao.getOne(1L));
        model.addAttribute("email", userDao.getOne(1L).getEmail());
        return "/posts/show";
    }

    @GetMapping(path = "/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        model.addAttribute("user", userDao.getOne(1L));
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
        post.setOwner(userDao.findAll().get(0));
        postDao.save(post);
        emailService.prepareAndSendPost(post, "New Post Created: " + post.getTitle(), post.getBody());
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/{id}/edit")
    public String editPostForm(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("id", id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping(path = "/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model model
    ) {
        Post post = postDao.getOne(id);
        model.addAttribute("post",post);
        postDao.save(post);
        emailService.prepareAndSendPost(post, ("Post Edited: " + post.getTitle()), post.getDescription());
        return "redirect:/posts/show/ + {id}";
    }

    @GetMapping(path = "/posts/delete/{id}")
    public String deletePostById(@PathVariable long id) {
        Post post = postDao.getOne(id);
        post.setOwner(postDao.getOne(id).getOwner());
        postDao.deleteById(id);
        emailService.prepareAndSendPost(post, ("Post Deleted: " + post.getTitle()), post.getBody());
        return "/posts/delete-message";
    }
}
