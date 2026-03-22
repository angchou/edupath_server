package com.example.server.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "NHANVIEN")
public class Employee {

    @Id
    @Column(name = "USER_ID", nullable = false)
    private String employeeId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
