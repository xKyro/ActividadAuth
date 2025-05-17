package com.example.auth_proyecto.payload;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
