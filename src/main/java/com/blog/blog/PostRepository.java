package com.blog.blog;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {


    public List<Post> findAll();

    public void savePost(Post post);

    public Post findPostById(Integer id);

}
