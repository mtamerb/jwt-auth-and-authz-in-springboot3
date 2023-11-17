package com.example.jwtauthandauthzinspringboot3.auth.service;


import com.example.jwtauthandauthzinspringboot3.auth.request.LoginRequest;
import com.example.jwtauthandauthzinspringboot3.auth.request.RegisterRequest;
import com.example.jwtauthandauthzinspringboot3.auth.response.AuthResponse;
import com.example.jwtauthandauthzinspringboot3.security.JwtService;
import com.example.jwtauthandauthzinspringboot3.user.entity.Role;
import com.example.jwtauthandauthzinspringboot3.user.entity.User;
import com.example.jwtauthandauthzinspringboot3.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    public AuthResponse register(RegisterRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return new AuthResponse("User with this email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .message("User registered successfully")
                .response(HttpStatus.CREATED)
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        String message = user.getRole().equals(Role.ADMIN) ? "Admin logged in successfully" : "User logged in successfully";

        return AuthResponse.builder()
                .message(message)
                .response(HttpStatus.OK)
                .token(token)
                .build();
    }


}
