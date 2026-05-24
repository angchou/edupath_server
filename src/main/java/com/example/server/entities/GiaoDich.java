package com.example.server.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "GIAODICH")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GiaoDich.procCreateTransaction",
                procedureName = "proc_create_transaction",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_user_id", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_khoa_hoc_id", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_voucher_id", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "p_cong_gd", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_status_code", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "p_message", type = String.class)
                }
        )
})
public class GiaoDich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GIAODICH_ID", nullable = false)
    private String giaoDichID;
    @Column(name = "GIAGOC", nullable = false)
    private BigDecimal giaGoc;
    @Column(name = "TRIGIA", nullable = false)
    private BigDecimal triGia;
    @Column(name = "NGAYGD", nullable = false)
    private LocalDateTime ngayGD;
    @Column(name = "TRANGTHAI", nullable = false)
    private int trangThai;
    @Column(name = "CONGGD", nullable = false)
    private int congGD;

    @ManyToOne
    @JoinColumn(name = "KHOAHOC_ID")
    private KhoaHoc khoaHoc;
    @ManyToOne
    @JoinColumn(name = "HOCVIEN_ID")
    private HocVien hocVien;
    @ManyToOne
    @JoinColumn(name = "VOUCHER_ID")
    private Voucher voucher;

    public String getGiaoDichID() {
        return giaoDichID;
    }

    public void setGiaoDichID(String giaoDichID) {
        this.giaoDichID = giaoDichID;
    }

    public BigDecimal getTriGia() {
        return triGia;
    }

    public void setTriGia(BigDecimal triGia) {
        this.triGia = triGia;
    }

    public BigDecimal getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(BigDecimal giaGoc) {
        this.giaGoc = giaGoc;
    }

    public LocalDateTime getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(LocalDateTime ngayGD) {
        this.ngayGD = ngayGD;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getCongGD() {
        return congGD;
    }

    public void setCongGD(int congGD) {
        this.congGD = congGD;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }
}
