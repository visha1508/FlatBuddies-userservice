package com.find.flat_buddies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/")
    public String getHomePage(){
        return "Welcome to Flat-buddy";
    }

}
