package com.sayaliblog.blogappapis.services;


import com.sayaliblog.blogappapis.payloads.PostDto;
import com.sayaliblog.blogappapis.payloads.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto user,Integer userid);
    UserDto getUserById(Integer userid);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userid);

    interface PostCategory {

        public PostDto addPost(PostDto postDto);

        public PostDto getPost(Integer postId);

        public PostDto updatePost(PostDto postDto);

        public void deletePost(Integer postId);

        public List<PostDto> getAllPost();

    }
}
