package com.example.server.dto.responses;

import java.time.LocalDateTime;

public class UserViewResponse {

    private String userId;
    private String username;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private Integer role;

    public UserViewResponse() {}

    public UserViewResponse(String userId, String name, String email, String phoneNumber, LocalDateTime createAt, Integer role) {
        this.userId = userId;
        this.username = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createAt;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
