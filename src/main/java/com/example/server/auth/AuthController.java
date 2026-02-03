package com.example.server.auth;

import com.example.server.dto.requests.UserLoginRequest;
import com.example.server.dto.responses.UserLoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

}
