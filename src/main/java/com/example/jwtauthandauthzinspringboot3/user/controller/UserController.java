package com.example.jwtauthandauthzinspringboot3.user.controller;


import com.example.jwtauthandauthzinspringboot3.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtService jwtService;

    private AuthenticationManager authenticationManager;
}
