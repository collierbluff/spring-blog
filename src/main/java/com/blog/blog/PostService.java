package com.blog.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

PostRepository postDao;

private List<Post> allPosts;

public PostService(PostRepository postDao){
    this.postDao = postDao;

}


public List<Post> findAll() {

    return postDao.findAll();
}

public Post findOne(int id){

    return postDao.findPostById(id);
}


public void save(Post post){
    postDao.savePost(post);
}





}
