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
//Replace getPosts() with index() to get all posts.

//    @GetMapping("/posts")
//    public String getPosts(Model model) {
//
//        ArrayList<Post> posts = new ArrayList<>();
//
//        posts.add(new Post(1,"Blog 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor. Sed aliquet non tortor nec placerat. Etiam viverra, mi quis tempor gravida, quam purus placerat est, sed ornare dolor nunc a risus. Aliquam elementum eros ipsum, id faucibus elit efficitur ut. Integer condimentum molestie velit, at dictum felis. Donec rhoncus posuere felis, id bibendum est accumsan in. Fusce magna augue, euismod id felis vel, pulvinar faucibus lacus. Duis viverra, turpis ac blandit gravida, nulla est congue nibh, sed aliquam ligula nibh vel magna. Maecenas bibendum pulvinar metus, at dictum ex pulvinar id. Fusce suscipit maximus turpis, et rutrum sapien tristique sit amet. Suspendisse potenti. Ut vehicula est nisl, a egestas est vehicula sit amet.\n" +
//                "\n"));
//        posts.add(new Post(2, "Blog 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor.", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor. Sed aliquet non tortor nec placerat. Etiam viverra, mi quis tempor gravida, quam purus placerat est, sed ornare dolor nunc a risus. Aliquam elementum eros ipsum, id faucibus elit efficitur ut. Integer condimentum molestie velit, at dictum felis. Donec rhoncus posuere felis, id bibendum est accumsan in. Fusce magna augue, euismod id felis vel, pulvinar faucibus lacus. Duis viverra, turpis ac blandit gravida, nulla est congue nibh, sed aliquam ligula nibh vel magna. Maecenas bibendum pulvinar metus, at dictum ex pulvinar id. Fusce suscipit maximus turpis, et rutrum sapien tristique sit amet. Suspendisse potenti. Ut vehicula est nisl, a egestas est vehicula sit amet.\n" + "\n"));
//
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }

    //new way using dependency injection
    @GetMapping("/posts/")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }


    //Return individual post (ideally by id in the future)
    @GetMapping(path = "/posts/show/{id}")
    public String getPostsById(@PathVariable long id, Model model) {

        Post post = new Post();

        post.setId(1);
        post.setTitle("Blog 1");
        post.setBody("\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor.");
        post.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam gravida leo hendrerit mi faucibus efficitur. Aliquam interdum ornare vestibulum. Morbi fermentum sagittis nulla sit amet auctor. Sed aliquet non tortor nec placerat. Etiam viverra, mi quis tempor gravida, quam purus placerat est, sed ornare dolor nunc a risus. Aliquam elementum eros ipsum, id faucibus elit efficitur ut. Integer condimentum molestie velit, at dictum felis. Donec rhoncus posuere felis, id bibendum est accumsan in. Fusce magna augue, euismod id felis vel, pulvinar faucibus lacus. Duis viverra, turpis ac blandit gravida, nulla est congue nibh, sed aliquam ligula nibh vel magna. Maecenas bibendum pulvinar metus, at dictum ex pulvinar id. Fusce suscipit maximus turpis, et rutrum sapien tristique sit amet. Suspendisse potenti. Ut vehicula est nisl, a egestas est vehicula sit amet.\n" +
                "\n");

        model.addAttribute("post", post);
        model.addAttribute("id", id);
        return "/posts/show";
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
