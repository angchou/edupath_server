package com.example.server.services;

import com.example.server.dto.requests.CreateEmployeeRequest;
import com.example.server.entities.Role;
import com.example.server.entities.User;
import com.example.server.entities.UserRole;
import com.example.server.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class AdminService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository usersRepository;


    public Optional<User> getUserByEmail(String email) {
        logger.info("Getting user by email " + email);
        return usersRepository.findByUserEmail(email);
    }

    public void deleteUserByEmail(String email) {
        if (!usersRepository.existsByUserEmail(email)) {
            logger.info("User doesn't exist");
            throw new RuntimeException("User not found!");
        }
        logger.info("Deleting user by email: " + email);
        usersRepository.deleteByUserEmail(email);
    }

}
