package com.find.flat_buddies.controller;

import com.find.flat_buddies.model.User;
import com.find.flat_buddies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /**
     *
     * @return home page content
     */
    @GetMapping("/")
    public String getHomePage(){
        return "Welcome to Flat-buddy";
    }

    /**
     *
     * @param user
     * @return string
     */
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);

        if (savedUser != null && savedUser.getEmailId() != null) {
            // User was successfully saved and has an ID
            return new ResponseEntity<>("User saved successfully", HttpStatus.CREATED);
        } else {
            // If user is not saved
            return new ResponseEntity<>("Failed to save user", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @return all users
     */
    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllUsers() {
        List<User> users= userService.getAllUsers();

        if (users.isEmpty())
            //No users Found
            return new ResponseEntity<>("No users found", HttpStatus.OK);
        else
            //Returning Users
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
