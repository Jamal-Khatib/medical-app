package com.example.medicalapp.services;

import com.example.medicalapp.dtos.UpdatedUserDTO;
import com.example.medicalapp.repositories.UserRepo;
import com.example.medicalapp.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User addUser(User user){
        User user1 = userRepo.save(user) ;
        return user1;
    }

    public User getUser(String email, String password){
        List<User> users = userRepo.findByEmailAndPassword(email,password);
        if(users.size()>1 || users.isEmpty()) return null ;
        return users.get(0) ;
    }

    public User getUser(Long id){
        return userRepo.findById(id).get() ;
    }


    public User updateUser(Long userId, UpdatedUserDTO updatedUser) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update existingUser with data from updatedUser
            existingUser.setFullName(updatedUser.getFirstName()+" "+updatedUser.getLastName());
            existingUser.setEmail(updatedUser.getEmail());
            // Save the updated user
            return userRepo.save(existingUser);
        } else {
            return null; // User not found, handle accordingly
        }
    }

    }
