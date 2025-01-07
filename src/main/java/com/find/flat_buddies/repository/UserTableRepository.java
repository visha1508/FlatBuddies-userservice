package com.find.flat_buddies.repository;

import com.find.flat_buddies.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTableRepository extends JpaRepository<User, Long> {

    Boolean existsByEmailId(String emailId);
    User findByEmailId(String emailId);
}
