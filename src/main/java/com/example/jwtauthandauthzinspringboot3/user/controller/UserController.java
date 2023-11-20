package com.example.jwtauthandauthzinspringboot3.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    @PostMapping("/panel")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> userPanel() {
        return ResponseEntity.ok("Welcome to the is user panel");
    }


}
