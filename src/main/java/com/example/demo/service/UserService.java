// package com.example.demo.service;

// import com.example.demo.model.User;
// import com.example.demo.repository.UserRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;


// @Service
// public interface  UserService {

//     @Autowired
//     private UserRepository userRepository;

//     @Autowired
//     private PasswordEncoder passwordEncoder;

//     // ================= FIND BY EMAIL =================
//     User findByEmail(String email) {
//         return userRepository.findByEmail(email).orElse(null);
//     }

//     // ================= REGISTER USER =================
//     User register(String name, String email, String password) {

//         // check duplicate email
//         if (userRepository.findByEmail(email).isPresent()) {
//             throw new RuntimeException("Email already exists");
//         }

//         User user = new User();
//         user.setName(name);
//         user.setEmail(email);
//         user.setPassword(passwordEncoder.encode(password));
//         user.setRole("RESIDENT"); // default role

//         return userRepository.save(user);
//     }
// }

package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User findByEmail(String email);

    User saveUser(User user);   // For saving user from AuthController

    User register(String name, String email, String password, String role);

    public User findById(Long id);

}

