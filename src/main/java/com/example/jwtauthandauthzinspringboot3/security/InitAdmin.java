package com.example.jwtauthandauthzinspringboot3.security;

import com.example.jwtauthandauthzinspringboot3.user.entity.Role;
import com.example.jwtauthandauthzinspringboot3.user.entity.User;
import com.example.jwtauthandauthzinspringboot3.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitAdmin implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        final String admin = "admin";
        if (userRepository.count() == 0) {
            log.info("No user found, creating admin user");
            userRepository.save(
                    User.builder()
                            .firstName(admin)
                            .lastName(admin)
                            .email(admin + "@example.com")
                            .password(new BCryptPasswordEncoder().encode("_admin_"))
                            .role(Role.ADMIN)
                            .build());

        } else {
            log.warn("Admin user already exists");
        }

    }
}
