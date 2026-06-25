package com.alicorp.demo_alicorp.controller;

import com.alicorp.demo_alicorp.dto.request.LoginRequest;
import com.alicorp.demo_alicorp.dto.response.AuthResponse;
import com.alicorp.demo_alicorp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}