package com.example.server.services;

import com.example.server.entities.User;
import com.example.server.repositories.UserRepository;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    // GET
    public Optional<User> getUserByEmail(String email) {
        logger.info("Getting user by email: " + email);
        return userRepository.findByEmail(email);
    }

    // POST
    public User createUser(String userName, String email, String password, String phoneNumber) {
        User user = new User();
        user.setName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setCreated_at(LocalDateTime.now());

        return userRepository.save(user);
    }
}
