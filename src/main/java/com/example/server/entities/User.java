package com.example.server.entities;

import com.example.server.role.Role;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userId;
    @Column(name="USER_NAME")
    private String name;
    @Column(name="USER_EMAIL")
    private String email;
    @Column(name="USER_PASSWORD")
    private String password;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="USER_ROLE")
//    private Role role;
    @Column(name="USER_ROLE")
    private Integer role;
    @Column(name="USER_PHONENUMBER")
    private String phoneNumber;
    @Column(name="CREATED_AT")
    private LocalDateTime createAt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
