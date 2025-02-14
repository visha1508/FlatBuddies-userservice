package com.find.flat_buddies.controller;

import com.find.flat_buddies.dto.LoginDto;
import com.find.flat_buddies.model.User;
import com.find.flat_buddies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin( origins = "*")
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
    
    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody LoginDto loginDto){
    	User user = userService.login(loginDto);
    	if(user.getId() > 0)
    		return new ResponseEntity<>(user, HttpStatus.OK);
    	
    	return new ResponseEntity<>("Login Failed", HttpStatus.NOT_FOUND);
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
