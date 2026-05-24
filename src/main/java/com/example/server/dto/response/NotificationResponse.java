package com.example.server.dto.response;

import com.example.server.entities.ThongBao;

import java.time.LocalDate;

public class NotificationResponse {
    private String thongBaoID;
    private String tieuDe;
    private String noiDung;
    private LocalDate ngayTao;

    public NotificationResponse(ThongBao thongBao) {
        this.thongBaoID = thongBao.getThongBaoID();
        this.tieuDe = thongBao.getTieuDe();
        this.noiDung = thongBao.getNoiDung();
        this.ngayTao = thongBao.getNgayTao();
    }

    public String getThongBaoID() {
        return thongBaoID;
    }

    public void setThongBaoID(String thongBaoID) {
        this.thongBaoID = thongBaoID;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }
}
