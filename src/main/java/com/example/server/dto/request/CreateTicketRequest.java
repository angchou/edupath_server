package com.example.server.dto.request;

public class CreateTicketRequest {
    private String moTa;
    private int loaiTicket;

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getLoaiTicket() {
        return loaiTicket;
    }

    public void setLoaiTicket(int loaiTicket) {
        this.loaiTicket = loaiTicket;
    }
}
