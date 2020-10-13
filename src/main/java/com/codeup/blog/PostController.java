package com.codeup.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "/posts/create-form";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "date") String date,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description,
            @RequestParam(name = "body") String body
            ){
        Post post = new Post();
        post.setDate(date);
        post.setTitle(title);
        post.setDescription(description);
        post.setBody(body);
        // save the post
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String editPostForm(@PathVariable long id, Model model) {
        Post post = postDao.getOne(id);
        model.addAttribute("id", id);
        model.addAttribute("post", post);
        return "/posts/edit-form";
    }

    @PostMapping(path = "/posts/edit/")
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
//        post.setSlug(slug);
        // save the post
        postDao.save(post);
        return "redirect:/posts/show/ + {id}";
    }

    @GetMapping(path = "/posts/delete/{id}")
    public String deletePostById(@PathVariable long id, Model model) {
            postDao.deleteById(id);
            model.addAttribute("id", id);
        return "/posts/delete-message";
    }
}
