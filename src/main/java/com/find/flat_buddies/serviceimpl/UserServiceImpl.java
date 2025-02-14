package com.find.flat_buddies.serviceimpl;

import com.find.flat_buddies.dto.LoginDto;
import com.find.flat_buddies.model.PropertyDetails;
import com.find.flat_buddies.model.User;
import com.find.flat_buddies.repository.UserTableRepository;
import com.find.flat_buddies.service.UserService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserTableRepository userTableRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public User registerUser(User user) {
        if(userTableRepository.existsByEmailId(user.getEmailId()))
            return null;
        
        
         List<PropertyDetails> properties = user.getProperty();
         
         user.setProperty(properties);
        user.setPassword(encoder.encode(user.getPassword()));
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
    
    @Override
	public User login(LoginDto loginDto) {
		 User userObj = userTableRepository.findByEmailId(loginDto.getUsername());
	        if(userObj == null) {
	            System.out.println("user not found");
	        }
	        if(encoder.matches(loginDto.getPassword(), userObj.getPassword())) {
	        	 return userObj ;
	        }
	        else {
	        	System.out.println("Incorrect Password");
	        }
	        return null;
	       
	}
}
