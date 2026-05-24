package com.example.server.dto.request;

public class ChangePasswordRequest {
    private String password;
    private String new_password;
    private String reenter_password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getReenter_password() {
        return reenter_password;
    }

    public void setReenter_password(String reenter_password) {
        this.reenter_password = reenter_password;
    }
}
