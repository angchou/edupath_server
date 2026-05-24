package com.example.server.dto.response;

public class BankAccountResponse {
    private String tknhID;
    private String stk;
    private String tenNH;
    private Integer trangThai;

    public BankAccountResponse(String tknhID, String stk, String tenNH, Integer trangThai) {
        this.tknhID = tknhID;
        this.stk = stk;
        this.tenNH = tenNH;
        this.trangThai = trangThai;
    }

    public String getTknhID() {
        return tknhID;
    }

    public void setTknhID(String tknhID) {
        this.tknhID = tknhID;
    }

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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
}
