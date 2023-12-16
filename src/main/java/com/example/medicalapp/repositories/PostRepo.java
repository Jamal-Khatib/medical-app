package com.example.medicalapp.repositories;


import com.example.medicalapp.tables.Post;
import com.example.medicalapp.tables.User;
import org.hibernate.type.ListType;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

    List<Post> findAll(Sort sortByDateDesc);

}
