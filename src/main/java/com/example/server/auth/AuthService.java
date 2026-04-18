package com.example.server.auth;

import com.example.server.dto.request.RegisterRequest;
import com.example.server.dto.response.TokenResponse;
import com.example.server.entities.Role;
import com.example.server.entities.UserRole;
import com.example.server.entities.Users;
import com.example.server.repositories.RoleRepository;
import com.example.server.repositories.UserRepository;
import com.example.server.repositories.UserRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AuthService {

    private static final Logger logger = Logger.getLogger(AuthService.class.getName());


    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private JwtUtil jwt;

    // login
    @Transactional
    public TokenResponse login(String email, String password) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email doesn't exists!"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Wrong password!");
        }

        List<UserRole> userRoles = userRoleRepository.findByUser_UserID(user.getUserID());
        String token = jwt.generateToken(user, userRoles);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return tokenResponse;
    }

    @Transactional
    public ResponseEntity<?> register(RegisterRequest request) {
        if (usersRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("Account already exists");

        // create new User
        Users user = new Users();
        user.setHoTen(request.getHoTen());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        usersRepository.save(user);

        // get Role
        Role role = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        // create User Role
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);

        return ResponseEntity.ok().build();
    }

}
