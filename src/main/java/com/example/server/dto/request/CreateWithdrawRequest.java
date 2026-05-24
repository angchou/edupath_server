package com.example.server.dto.request;

import java.math.BigDecimal;

public class CreateWithdrawRequest {
    private BigDecimal soTienRut;
    private String tknhID;

    public BigDecimal getSoTienRut() { return soTienRut; }
    public void setSoTienRut(BigDecimal soTienRut) { this.soTienRut = soTienRut; }
    public String getTknhID() { return tknhID; }
    public void setTknhID(String tknhID) { this.tknhID = tknhID; }
}
