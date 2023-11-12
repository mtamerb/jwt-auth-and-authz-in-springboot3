package com.example.jwtauthandauthzinspringboot3.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> homePanel() {
        return ResponseEntity.ok("Welcome to home panel");
    }


}
