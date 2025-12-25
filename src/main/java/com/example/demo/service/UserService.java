
package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User findByEmail(String email);

    User saveUser(User user);   // For saving user from AuthController

    User register(String name, String email, String password, String role);

    public User findById(Long id);

}

