package com.sayaliblog.blogappapis.controllers;


import com.sayaliblog.blogappapis.entities.Post;
import com.sayaliblog.blogappapis.payloads.PostDto;
import com.sayaliblog.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable int userId,
            @PathVariable int categoryId)
    {
        PostDto createPostDto = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPost(Integer id) {
        return ResponseEntity.ok(this.postService.getPost(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return ResponseEntity.ok(this.postService.getAllPosts());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PostDto> updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
//
//        return ;
//    }
}
