package com.codeup.blog.hidden;

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

    @GetMapping(path = "/posts/show/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        User user = userDao.getOne(1L);
        model.addAttribute("post", post);
        model.addAttribute("user", user);
        model.addAttribute("email", user.getEmail());
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
        model.addAttribute("user", userDao.getOne(1L));
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "body") String body,
            String slug
    ) {
        User user = userDao.getOne(1L); // just use the first user in the db
        Post post = new Post();
        post.setDate(date);
        post.setTitle(title);
        post.setDescription(description);
        post.setBody(body);
        post.setSlug("#");
        post.setOwner(user);
        // save the post
        postDao.save(post);
        emailService.prepareAndSendPost(post, "New Post Created: " + post.title, post.body);
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
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "date") String date,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "body") String body
//            @RequestParam(name = "slug") String slug
    ) {
        Post post = postDao.getOne(id);
        post.setDate(date);
        post.setTitle(title);
        post.setDescription(description);
        post.setBody(body);
//        post.setOwner(userDao.getOne(1L));
//        post.setSlug(slug);
        postDao.save(post);
        emailService.prepareAndSendPost(post, ("Post Edited: " + title), description);
        return "redirect:/posts/show/ + {id}";
    }

    @GetMapping(path = "/posts/delete/{id}")
    public String deletePostById(@PathVariable long id, Model model, Post post) {
        postDao.deleteById(id);
//        post.setOwner(userDao.getOne(1L));
        model.addAttribute("id", id);
        emailService.prepareAndSendPost(post, ("Post Deleted: " + post.title), post.description);
        return "/posts/delete-message";
    }
}