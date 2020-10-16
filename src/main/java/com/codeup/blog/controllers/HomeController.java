//package com.codeup.blog.controllers;
//
//import com.codeup.blog.hidden.PostRepository;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//
//@Controller
//public class HomeController {
//
//    private final PostRepository postDao;
//
//    private HomeController(PostRepository postDao) {
//        this.postDao = postDao;
//    }
//
//    @GetMapping("/")
//    public String homepage(Model model) {
//        model.addAttribute("posts", postDao.findAll());
//        return "/home";
//    }
//
//}
//
