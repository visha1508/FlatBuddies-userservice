package com.find.flat_buddies.service;

import com.find.flat_buddies.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User registerUser(User user);
    List<User> getAllUsers();
    void deleteUserById(Long id);

}
