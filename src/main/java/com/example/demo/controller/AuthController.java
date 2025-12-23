package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));

    user.setRole(request.getRole() != null ? request.getRole() : "RESIDENT");

    User savedUser = userService.saveUser(user);
    return ResponseEntity.ok(savedUser);
}

@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    User user = userService.findByEmail(loginRequest.getEmail());

    if (user == null || !passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        return ResponseEntity.status(401).body("Invalid email or password");
    }

    String token = jwtTokenProvider.generateToken(
            user.getEmail(),
            user.getId(),
            user.getRole() != null ? user.getRole() : "RESIDENT"
    );

    LoginResponse response = new LoginResponse(
            token,
            user.getId(),
            user.getEmail(),
            user.getRole() != null ? user.getRole() : "RESIDENT"
    );

    return ResponseEntity.ok(response);
}

}
