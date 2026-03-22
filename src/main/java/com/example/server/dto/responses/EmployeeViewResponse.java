package com.example.server.dto.responses;

import com.example.server.entities.Role;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeViewResponse {

    private String user_id;
    private String username;
    private String email;
    private Integer status;
    private LocalDateTime created_at;
    private List<String> user_role;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public List<String> getUser_role() {
        return user_role;
    }

    public void setUser_role(List<String> user_role) {
        this.user_role = user_role;
    }
}
