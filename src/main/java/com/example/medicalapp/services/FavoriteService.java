package com.example.medicalapp.services;

import com.example.medicalapp.repositories.FavoriteRepo;
import com.example.medicalapp.repositories.PostRepo;
import com.example.medicalapp.tables.Favorite;
import com.example.medicalapp.tables.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    FavoriteRepo favoriteRepo ;

    @Autowired
    PostRepo postRepo ;

    public void updateFavoriteStatus(Long userId, Long postId, boolean favorite){
        try{
            if(favorite){
                Favorite favoriteObj = new Favorite();
                favoriteObj.setUserId(userId);
                favoriteObj.setPostId(postId);
                favoriteRepo.save(favoriteObj) ;
            }
            else{
                Optional<Favorite> favoriteObj = favoriteRepo.findByUserIdAndPostId(userId, postId);
                if (favoriteObj.isPresent()) {
                    favoriteRepo.delete(favoriteObj.get());
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<Post> getFavorites(Long userId){
        List<Favorite> favorites = favoriteRepo.findAllByUserId(userId) ;
        List<Post> posts = new ArrayList<>() ;
        for(Favorite fv : favorites){
            Optional<Post> post = postRepo.findById(fv.getPostId()) ;
            if(post.isPresent()) posts.add(post.get()) ;
        }
        return posts ;
    }
}
