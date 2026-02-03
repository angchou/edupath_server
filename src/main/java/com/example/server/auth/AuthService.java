package com.example.server.auth;

import com.example.server.dto.responses.UserLoginResponse;
import com.example.server.entities.User;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AuthService {

    private static final Logger logger = Logger.getLogger(AuthService.class.getName());


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwt;

    // login
    public UserLoginResponse login(String email, String password) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found."));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password.");
        }

        String token = jwt.generateToken(user);

        return new UserLoginResponse(
                token,
                email,
                user.getRole()
        );
    }

}
