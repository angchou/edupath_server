package com.example.server.dto.request;

public class RegisterRequest {
    private String hoTen;
    private String email;
    private String password;
    private String reenter_password;

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getReenter_password() {
        return reenter_password;
    }
}
