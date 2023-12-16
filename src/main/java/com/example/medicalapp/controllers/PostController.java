package com.example.medicalapp.controllers;


import com.example.medicalapp.dtos.PostRequestDto;
import com.example.medicalapp.services.PostService;
import com.example.medicalapp.tables.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
public class PostController {

    @Autowired
    PostService postService ;

    //Get all posts except user
    @GetMapping("/posts")
    public List<Post> getPosts(){
        List posts =  postService.getAllPost() ;
        return posts ;
    }

    //Create a Post
    @PostMapping("/post")
    public void createPost(@RequestBody PostRequestDto postRequestDto){
        postService.createPost(postRequestDto) ;
    }
}
