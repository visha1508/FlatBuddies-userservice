package com.find.flat_buddies.serviceimpl;

import com.find.flat_buddies.model.User;
import com.find.flat_buddies.repository.UserTableRepository;
import com.find.flat_buddies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserTableRepository userTableRepository;

    @Override
    public User registerUser(User user) {
        if(userTableRepository.existsByEmailId(user.getEmailId()))
            return null;

        User savedUser = userTableRepository.save(user);

        return savedUser.getId() != null ? savedUser : null;
    }

    @Override
    public List<User> getAllUsers() {

        if(userTableRepository.findAll().isEmpty())
            return null;
        else
            return userTableRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        if(id != null)
            userTableRepository.deleteById(id);
    }
}
