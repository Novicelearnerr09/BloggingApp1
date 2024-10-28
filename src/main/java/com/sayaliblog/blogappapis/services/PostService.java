package com.sayaliblog.blogappapis.services;

import com.sayaliblog.blogappapis.entities.Post;
import com.sayaliblog.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {

    public PostDto getPost(Integer id);

    public List<PostDto> getAllPosts();

    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    public PostDto updatePost(PostDto postDto, Integer id);

    public void deletePost(Integer id);

    List<Post> getPostsByCategory(Integer categoryId);

    List<Post> getPostsbyUser(Integer userId);

    List<Post> searchPosts(String keyword);
}
