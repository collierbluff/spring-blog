package com.blog.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

private List<Post> allPosts;

public PostService(){
    allPosts = new ArrayList<>();
    createPosts();
}


public List<Post> findAll(){

    return allPosts;
}

public Post findOne(int id){

    return allPosts.get(id - 1);
}

private void createPosts(){

    save(new Post("Title", "Body"));
    save(new Post("Titley", "Bodie"));
    save(new Post("Titular", "Bowie"));
    save(new Post("Titanic", "Boxy"));

}

public void save(Post post){
    post.setId(allPosts.size() + 1);
    allPosts.add(post);
}





}
