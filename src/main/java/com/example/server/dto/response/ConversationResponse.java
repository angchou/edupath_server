package com.example.server.dto.response;

import java.time.LocalDate;

public class ConversationResponse {
    private String cuocTroChuyenID;
    private LocalDate thoiGianTao;
    private String nguoiKhoiTao;
    private String nguoiNhan;
    private boolean expired;

    public ConversationResponse(String cuocTroChuyenID, LocalDate thoiGianTao, String nguoiKhoiTao, String nguoiNhan, boolean expired) {
        this.cuocTroChuyenID = cuocTroChuyenID;
        this.thoiGianTao = thoiGianTao;
        this.nguoiKhoiTao = nguoiKhoiTao;
        this.nguoiNhan = nguoiNhan;
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getCuocTroChuyenID() {
        return cuocTroChuyenID;
    }

    public void setCuocTroChuyenID(String cuocTroChuyenID) {
        this.cuocTroChuyenID = cuocTroChuyenID;
    }

    public LocalDate getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(LocalDate thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getNguoiKhoiTao() {
        return nguoiKhoiTao;
    }

    public void setNguoiKhoiTao(String nguoiKhoiTao) {
        this.nguoiKhoiTao = nguoiKhoiTao;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }
}
