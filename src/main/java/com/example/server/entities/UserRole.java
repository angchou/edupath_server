package com.example.server.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERROLE_ID")
    private String userRoleId;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID", nullable = false)
    @JsonBackReference
    private Role role;
    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    @JsonBackReference
    private User user;

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
