package com.example.server.services;

import com.example.server.dto.requests.ChangePasswordRequest;
import com.example.server.dto.responses.CustomerViewResponse;
import com.example.server.entities.Role;
import com.example.server.entities.User;
import com.example.server.mappers.CustomerViewMapper;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UserService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private UserRepository usersRepository;

    public void changeUserPassword(ChangePasswordRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userId = auth.getName();

        User user = usersRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not Found!"));

        if (!request.getOld_password().equals(user.getUserPassword())) {
            throw new RuntimeException("Old password is not correct!");
        }

        if (request.getNew_password() == null || request.getNew_password().length() < 6) {
            throw new RuntimeException("Password must be at least 6 characters");
        }

        user.setUserPassword(request.getNew_password());
        usersRepository.save(user);
    }

    public List<CustomerViewResponse> getCustomers() {
        List<User> customers = usersRepository.findByUserStatus(1, List.of(1, 2));

        return customers
                .stream()
                .map(CustomerViewMapper::toViewResponse)
                .toList();
    }

    public Optional<User> getUserByEmail(String userEmail) {
        logger.info("Getting user by email " + userEmail);
        return usersRepository.findByUserEmail(userEmail);
    }
}
