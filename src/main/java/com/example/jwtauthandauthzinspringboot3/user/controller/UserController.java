package com.example.jwtauthandauthzinspringboot3.user.controller;

import com.example.jwtauthandauthzinspringboot3.auth.request.LoginRequest;
import com.example.jwtauthandauthzinspringboot3.auth.request.RegisterRequest;
import com.example.jwtauthandauthzinspringboot3.auth.response.AuthResponse;
import com.example.jwtauthandauthzinspringboot3.auth.service.AuthService;
import com.example.jwtauthandauthzinspringboot3.security.JwtService;
import com.example.jwtauthandauthzinspringboot3.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {


    private final AuthService authService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> homePanel() {
        return ResponseEntity.ok("Welcome to home panel");
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(authService.register(registerRequest));
    }



}
