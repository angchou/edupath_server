package com.example.server.dto.responses;

import com.example.server.role.Role;

public class UserLoginResponse {

    private String token;
    private String email;
    private Integer role;

    public UserLoginResponse(String token, String email, Integer role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}
