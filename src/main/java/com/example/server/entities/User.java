package com.example.server.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String userId;
    @Column(name = "HOTEN", nullable = false)
    private String userName;
    @Column(name = "EMAIL", nullable = false)
    private String userEmail;
    @Column(name = "PASSWORD", nullable = false)
    private String userPassword;
    @Column(name = "TRANGTHAI", nullable = false)
    private Integer userStatus;
    @Column(name = "NGAYTAO", nullable = false)
    private String userCreatedAt;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserRole> userRole;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }
}