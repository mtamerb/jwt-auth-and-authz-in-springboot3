package com.example.jwtauthandauthzinspringboot3.auth.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthRespose {

    private String email;
    private String password;
}
