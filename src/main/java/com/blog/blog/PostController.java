package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }


//  Bundled together individual post and many post viewing to the same url
    @GetMapping("/posts")
    private String posts(@RequestParam(value = "id", defaultValue = "All") String id, Model model){

        if(id.equals("All")){

            List<Post> allPosts = postService.findAll();

            model.addAttribute("posts", allPosts);

            return "posts/index";
        }


        Post post = postService.findOne(Integer.parseInt(id));

        model.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    private String createPostForm(Model model){

        model.addAttribute("post", new Post());

        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insertPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts";
    }
}
