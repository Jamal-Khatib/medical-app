package com.example.medicalapp.repositories;

import com.example.medicalapp.tables.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    Optional<User> findById(Long id);


    List<User> findByEmailAndPassword(String email, String password);
}
