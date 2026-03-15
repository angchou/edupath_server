package com.example.server.services;

import com.example.server.entities.User;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository usersRepository;

    public Optional<User> getUserByEmail(String userEmail) {
        logger.info("Getting user by email " + userEmail);
        return usersRepository.findByUserEmail(userEmail);
    }
}
