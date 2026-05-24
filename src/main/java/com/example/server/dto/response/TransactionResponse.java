package com.example.server.dto.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionResponse {
    private String giaoDichID;
    private BigDecimal giaGoc;
    private BigDecimal triGia;
    private LocalDateTime ngayGD;
    private Integer congGD;
    private Integer trangThai;

    private String voucherID;
    private String maApDung;

    private String khoaHocID;
    private String userID;

    private boolean isRefunded;

    public TransactionResponse(String giaoDichID, BigDecimal giaGoc, BigDecimal triGia, LocalDateTime ngayGD, Integer congGD, Integer trangThai, String voucherID, String maApDung, String khoaHocID, boolean isRefunded) {
        this.giaoDichID = giaoDichID;
        this.giaGoc = giaGoc;
        this.triGia = triGia;
        this.ngayGD = ngayGD;
        this.congGD = congGD;
        this.trangThai = trangThai;
        this.voucherID = voucherID;
        this.maApDung = maApDung;
        this.khoaHocID = khoaHocID;
        this.isRefunded = isRefunded;
    }

    private String hoanTienID;
    private LocalDate ngayHT;
    private String liDo;
    private LocalDateTime ngayTao;
    private BigDecimal phiSan;

    public TransactionResponse(String giaoDichID, BigDecimal giaGoc, BigDecimal triGia, LocalDateTime ngayGD, Integer congGD, Integer trangThai, String voucherID, String maApDung, String khoaHocID, String hoanTienID, LocalDate ngayHT, String liDo, LocalDateTime ngayTao, BigDecimal phiSan) {
        this.giaoDichID = giaoDichID;
        this.giaGoc = giaGoc;
        this.triGia = triGia;
        this.ngayGD = ngayGD;
        this.congGD = congGD;
        this.trangThai = trangThai;
        this.voucherID = voucherID;
        this.maApDung = maApDung;
        this.khoaHocID = khoaHocID;
        this.hoanTienID = hoanTienID;
        this.ngayHT = ngayHT;
        this.liDo = liDo;
        this.ngayTao = ngayTao;
        this.phiSan = phiSan;
    }

    public LocalDate getNgayHT() {
        return ngayHT;
    }

    public void setNgayHT(LocalDate ngayHT) {
        this.ngayHT = ngayHT;
    }

    public LocalDateTime getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDateTime ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getHoanTienID() {
        return hoanTienID;
    }

    public void setHoanTienID(String hoanTienID) {
        this.hoanTienID = hoanTienID;
    }

    public String getLiDo() {
        return liDo;
    }

    public void setLiDo(String liDo) {
        this.liDo = liDo;
    }

    public BigDecimal getPhiSan() {
        return phiSan;
    }

    public void setPhiSan(BigDecimal phiSan) {
        this.phiSan = phiSan;
    }

    public TransactionResponse() {}

    public boolean isRefunded() {
        return isRefunded;
    }

    public void setRefunded(boolean refunded) {
        isRefunded = refunded;
    }

    public String getGiaoDichID() {
        return giaoDichID;
    }

    public void setGiaoDichID(String giaoDichID) {
        this.giaoDichID = giaoDichID;
    }

    public BigDecimal getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(BigDecimal giaGoc) {
        this.giaGoc = giaGoc;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public LocalDateTime getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(LocalDateTime ngayGD) {
        this.ngayGD = ngayGD;
    }

    public Integer getCongGD() {
        return congGD;
    }

    public void setCongGD(Integer congGD) {
        this.congGD = congGD;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

    public String getMaApDung() {
        return maApDung;
    }

    public void setMaApDung(String maApDung) {
        this.maApDung = maApDung;
    }

    public String getKhoaHocID() {
        return khoaHocID;
    }

    public void setKhoaHocID(String khoaHocID) {
        this.khoaHocID = khoaHocID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
