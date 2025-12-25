package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AuthResponse {

    
    private String token;
    private Long userId;
    private String email;
    private String role;

    public AuthResponse(String token, Long userid, String email, String role) {
        this.token=token;
        this.userId=userid;
        this.email=email;
        this.role=role;
    }
}
