package com.blog.blog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {


//  Bundled together individual post and many post viewing to the same url
    @GetMapping("/posts")
    @ResponseBody
    private String posts(@RequestParam(value = "id", defaultValue = "All") String id){

        if(id.equals("All")){
            return "This will be the index page.";
        }

        return "This will be the individual post page for id number " + id + " .";
    }

//    Has unnecessary functionality for testing query strings
    @GetMapping("/posts/create")
    @ResponseBody
    private String createPostForm(){
        return "This will be the create posts form <br><form action = '/posts' method = 'GET'><input type='text' name ='id'><button>Submit</button></form>";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    private String createPost(){
        return "This will be where new posts are created";
    }
}
