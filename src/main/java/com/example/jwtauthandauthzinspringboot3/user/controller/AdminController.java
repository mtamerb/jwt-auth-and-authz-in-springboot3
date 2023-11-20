package com.example.jwtauthandauthzinspringboot3.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @PostMapping("/panel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> adminPanel() {
        return ResponseEntity.ok("Welcome to the is admin panel");
    }

}
