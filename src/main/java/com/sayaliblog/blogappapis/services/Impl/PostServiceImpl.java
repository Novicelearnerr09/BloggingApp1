package com.sayaliblog.blogappapis.services.Impl;

import com.sayaliblog.blogappapis.entities.Category;
import com.sayaliblog.blogappapis.entities.Post;
import com.sayaliblog.blogappapis.entities.User;
import com.sayaliblog.blogappapis.exceptions.ResourceNotFoundException;
import com.sayaliblog.blogappapis.payloads.PostDto;
import com.sayaliblog.blogappapis.repositories.CategoryRepo;
import com.sayaliblog.blogappapis.repositories.PostRepo;
import com.sayaliblog.blogappapis.repositories.UserRepo;
import com.sayaliblog.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;




    @Override
    public PostDto getPost(Integer id) {
        Post p1 =this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));
        PostDto dto = this.modelMapper.map(p1, PostDto.class);
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = this.postRepo.findAll();
        List<PostDto> postDtos = posts.stream().map((variable)->this.modelMapper.map(variable, PostDto.class)).collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user", "user Id", userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "category Id", categoryId));
        Post post=this.modelMapper.map(postDto, Post.class);
        post.setImage("default.png");
        post.setAddeddate(new Date());
        post.setCategory(category);
        post.setUser(user);
        Post newPost=this.postRepo.save(post);
        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer id) {
        Post p1 = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));

        p1.setTitle(postDto.getTitle());
        p1.setContent(postDto.getContent());
        p1.setImage(postDto.getImage());
        p1.setAddeddate(postDto.getAddeddate());

       Post finalpost = this.postRepo.save(p1);
       return this.modelMapper.map(finalpost, PostDto.class);
    }

    @Override
    public void deletePost(Integer id) {
        Post p1 = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id", id));
        this.postRepo.delete(p1);

    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return List.of();
    }

    @Override
    public List<Post> getPostsbyUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
