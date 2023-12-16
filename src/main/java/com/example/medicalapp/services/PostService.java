package com.example.medicalapp.services;

import com.example.medicalapp.dtos.PostRequestDto;
import com.example.medicalapp.repositories.PostRepo;
import com.example.medicalapp.tables.Post;
import com.example.medicalapp.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepo postRepo ;

    @Autowired
    UserService userService ;

   public List<Post> getAllPost(){
       try {
           // Sort posts by date in descending order
           Sort sortByDateDesc = Sort.by(Sort.Direction.DESC, "date");

           List<Post> posts = (List<Post>) postRepo.findAll(sortByDateDesc);
           return posts;
       }
       catch (Exception e) {
           return null ;
       }
   }

   public Post createPost(PostRequestDto postRequestDto){
       Post post = new Post() ;
       post.setBody(postRequestDto.getBody());
       post.setTitle(postRequestDto.getTitle());
       post.setType(postRequestDto.getType());
       post.setDate(new Date()); ;
       User user = userService.getUser(postRequestDto.getUserId()) ;
       post.setUser(user);
       return postRepo.save(post) ;
   }
}
