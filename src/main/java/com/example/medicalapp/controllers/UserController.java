package com.example.medicalapp.controllers;

import com.example.medicalapp.dtos.UpdatedUserDTO;
import com.example.medicalapp.services.UserService;
import com.example.medicalapp.tables.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Replace with your React app's URL
public class UserController {

    @Autowired
    UserService userService ;

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam String email, @RequestParam String password){
        User user = userService.getUser(email,password) ;
          if(user!=null){
              return new ResponseEntity<>(user, HttpStatus.OK);
          }
          else {
              return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
          }
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUser(userId) ;
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam Long userId, @RequestBody UpdatedUserDTO updatedUserDTO){
        userService.updateUser(userId,updatedUserDTO);
    }



}
