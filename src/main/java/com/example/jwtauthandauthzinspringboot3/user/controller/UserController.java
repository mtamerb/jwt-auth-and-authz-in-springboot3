package com.example.jwtauthandauthzinspringboot3.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> homePanel() {
        return ResponseEntity.ok("Welcome to home panel");
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> userPanel() {
        return ResponseEntity.ok("Welcome to the is user panel");
    }

    @PostMapping("/admin")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> adminPanel() {
        return ResponseEntity.ok("Welcome to the is admin panel");
    }

}
