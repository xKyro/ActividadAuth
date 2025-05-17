package com.example.auth_proyecto.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testing")
public class TestController {
    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> userAccess(Principal principal) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Contenido de usuario accesible");
        response.put("username", principal.getName());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> adminAccess() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Contenido de administrador accesible");
        return ResponseEntity.ok(response);
    }
}
