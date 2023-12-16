package com.example.medicalapp.controllers;

import com.example.medicalapp.services.FavoriteService;
import com.example.medicalapp.tables.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService ;

    @GetMapping("/favorite/{userId}")
    public List<Post> getFavorites(@PathVariable Long userId){
        return favoriteService.getFavorites(userId);
    }

    @PostMapping("/favorite/{userId}/{postId}")
    public void favorite(@PathVariable Long userId, @PathVariable Long postId, @RequestParam boolean favorite){
         favoriteService.updateFavoriteStatus(userId,postId,favorite) ;
    }

}
