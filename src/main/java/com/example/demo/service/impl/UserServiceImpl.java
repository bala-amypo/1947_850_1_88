package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ================= FIND USER BY EMAIL =================
    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // ================= SAVE USER =================
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // ================= REGISTER USER =================
    @Override
    public User register(String name, String email, String password, String role) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));

        // ✅ Assign role
        if (role == null || role.isBlank()) {
            user.setRole("RESIDENT");   // Default
        } else {
            user.setRole(role.toUpperCase());
        }

        return userRepository.save(user);
    }
    @Override
public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
}

}
