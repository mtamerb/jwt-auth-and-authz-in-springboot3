package com.example.jwtauthandauthzinspringboot3.auth.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class AuthResponse {

    private String token;
    private String message;
    private HttpStatus response;


    public AuthResponse(String token, String message, HttpStatus response) {
        this.token = token;
        this.message = message;
        this.response = response;
    }

    public AuthResponse(String message, HttpStatus response) {
        this.message = message;
        this.response = response;
    }
}
