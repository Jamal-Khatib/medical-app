package com.example.medicalapp.repositories;

import com.example.medicalapp.tables.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepo extends CrudRepository<Favorite, Long> {

    Optional<Favorite> findByUserIdAndPostId(Long userId, Long postId) ;

    List<Favorite> findAllByUserId(Long userId) ;
}
