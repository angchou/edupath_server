package com.example.server.auth;

import com.example.server.dto.requests.UserLoginRequest;
import com.example.server.dto.requests.UserRegisterRequest;
import com.example.server.dto.responses.UserLoginResponse;
import com.example.server.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public UserLoginResponse login(@RequestBody UserLoginRequest request) {
        return authService.login(request.getUser_email(), request.getUser_password());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest request) {
        User user = authService.register(request);
        return ResponseEntity.ok(Map.of("Message", "Register Success"));
    }

}