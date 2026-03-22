package com.example.server.dto.requests;

public class UpdateEmployeeRequest {

    private String user_id;
    private String new_username;
    private String new_email;
    private String new_password;
    private Integer new_status;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getNew_username() {
        return new_username;
    }

    public void setNew_username(String new_username) {
        this.new_username = new_username;
    }

    public String getNew_email() {
        return new_email;
    }

    public void setNew_email(String new_email) {
        this.new_email = new_email;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public Integer getNew_status() {
        return new_status;
    }

    public void setNew_status(Integer new_status) {
        this.new_status = new_status;
    }
}
