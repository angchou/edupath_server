package com.example.server.controllers;

import com.example.server.entities.User;
import com.example.server.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        logger.info("Getting user by email: " + email);

        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PostMapping("/login")
    public ResponseEntity<User> userLogin(@RequestParam String email, @RequestParam String password) {
        Optional<User> userOptional = userService.getUserByEmail(email);
        if (userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if (!password.equals(userOptional.get().getPassword()))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PostMapping("/register")
    public ResponseEntity<User> userRegister(@RequestBody User user) {
        logger.info("Creating new User");
        User newUser = userService.createUser(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber()
        );
        return ResponseEntity.status(HttpStatus.OK).body(newUser);
    }
}
