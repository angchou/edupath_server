package com.example.server.dto.request;

public class CreateBankAccountRequest {
    private String stk;
    private String tenNH;

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }
}
