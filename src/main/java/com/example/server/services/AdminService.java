package com.example.server.services;

import com.example.server.dto.responses.UserViewResponse;
import com.example.server.entities.User;
import com.example.server.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class AdminService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByEmail(String email) {
        logger.info("Getting user by email " + email);
        return userRepository.findByEmail(email);
    }

    public void deleteUserByEmail(String email) {
        if (!userRepository.existsByEmail(email)) {
            logger.info("User doesn't exist");
            throw new RuntimeException("User not found!");
        }
        logger.info("Deleting user by email: " + email);
        userRepository.deleteByEmail(email);
    }

    public List<UserViewResponse> getNonAdminUsers() {
        List<User> users = userRepository.findByRoleNot(6);

        return users.stream().map(user -> new UserViewResponse(
                user.getUserId(),
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCreateAt(),
                user.getRole()
        )).toList();
    }
}
