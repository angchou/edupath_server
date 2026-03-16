package com.example.server.controllers;

import com.example.server.entities.User;
import com.example.server.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/{email}")
    @PreAuthorize("hasRole('LEARNER')")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> userOptional = adminService.getUserByEmail(email);
        if (userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @DeleteMapping("/delete/{email}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable String email) {
        try {
            adminService.deleteUserByEmail(email);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

//    @GetMapping("/users")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<List<UserViewResponse>> getUsers() {
//        List<UserViewResponse> users = adminService.getNonAdminUsers();
//        return ResponseEntity.ok(users);
//    }

}
