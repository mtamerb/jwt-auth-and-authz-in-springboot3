package com.example.jwtauthandauthzinspringboot3.user.controller;


import com.example.jwtauthandauthzinspringboot3.security.JwtService;
import com.example.jwtauthandauthzinspringboot3.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;

@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    private AuthenticationManager authenticationManager;
}
