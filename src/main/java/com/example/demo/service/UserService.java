package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User findByEmail(String email);

    User saveUser(User user);

    User register(String name, String email, String password, String role);
    
    User register(User user);

    User findById(Long id);
}
