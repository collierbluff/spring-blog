package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


//  Bundled together individual post and many post viewing to the same url
    @GetMapping("/posts")
    private String posts(@RequestParam(value = "id", defaultValue = "All") String id, Model model){

        if(id.equals("All")){

            List<Post> allPosts = new ArrayList<>();

            allPosts.add(new Post("Title", "Body"));
            allPosts.add(new Post("Second Title", "Body"));

            model.addAttribute("posts", allPosts);

            return "posts/index";
        }


        model.addAttribute("post", new Post("Title", "Body"));

        return "posts/show";
    }

//    Has unnecessary functionality for testing query strings
    @GetMapping("/posts/create")
    @ResponseBody
    private String createPostForm(){
        return "This will be the create posts form <br>Here's a form for testing /posts<br><form action = '/posts' method = 'GET'><input type='text' name ='id'><button>Submit</button></form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    private String createPost(){
        return "This will be where new posts are created";
    }
}
