package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);

    public User saveUser(User user);

    public User findById(Long userId);
}
