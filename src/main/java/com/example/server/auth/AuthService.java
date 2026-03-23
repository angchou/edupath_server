package com.example.server.auth;

import com.example.server.dto.requests.UserRegisterRequest;
import com.example.server.dto.responses.UserLoginResponse;
import com.example.server.entities.Role;
import com.example.server.entities.UserRole;
import com.example.server.entities.User;
import com.example.server.repositories.RoleRepository;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private JwtUtil jwt;

    // login
    public UserLoginResponse login(String email, String password) {
        User user = usersRepository.findByUserEmail(email)
                .orElseThrow(() -> new RuntimeException("Email doesn't exists!"));

        if (!user.getUserPassword().equals(password)) {
            throw new RuntimeException("Wrong password!");
        }

        String token = jwt.generateToken(user);

        UserLoginResponse userLoginResponse = new UserLoginResponse();
        userLoginResponse.setToken(token);

        return userLoginResponse;
    }

    public User register(UserRegisterRequest request) {
        if (usersRepository.existsByUserEmail(request.getEmail()))
            throw new RuntimeException("Account already exists");

        // create new User
        User user = new User();
        user.setUserId("U002");
        user.setUserName(request.getName());
        user.setUserEmail(request.getEmail());
        user.setUserPassword(request.getPassword());

        // get Role
        Role role = roleRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Role Not Found"));

        // create User Role
        UserRole userRole = new UserRole();
        userRole.setUserRoleId("UR002");
        userRole.setUser(user);
        userRole.setRole(role);

        // add User Roles to user
        List<UserRole> roles = new ArrayList<>();
        roles.add(userRole);

        user.setUserRole(roles);

        // return user to dtb
        return user;
    }

}
