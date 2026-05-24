package com.example.server.entities;

import jakarta.persistence.*;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CHIPHIKM")
public class ChiPhiKM {
    @Id
    @Column(name = "CHIPHIKM_ID", nullable = false)
    private String chiPhiKMID;
    @Column(name = "SOTIENGIAM")
    private BigDecimal soTienGiam;
    @Column(name = "NGAYPHATSINH")
    private LocalDate ngayPhatSinh;

    @OneToOne
    @MapsId
    @JoinColumn(name = "GIAODICH_ID")
    private GiaoDich giaoDich;
    @OneToOne
    @JoinColumn(name = "VOUCHER_ID")
    private Voucher voucher;
    @ManyToOne
    @JoinColumn(name = "LOAINGANSACH")
    private LoaiNganSach loaiNganSach;

    public String getChiPhiKMID() {
        return chiPhiKMID;
    }

    public void setChiPhiKMID(String chiPhiKMID) {
        this.chiPhiKMID = chiPhiKMID;
    }

    public BigDecimal getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(BigDecimal soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public LocalDate getNgayPhatSinh() {
        return ngayPhatSinh;
    }

    public void setNgayPhatSinh(LocalDate ngayPhatSinh) {
        this.ngayPhatSinh = ngayPhatSinh;
    }

    public GiaoDich getGiaoDich() {
        return giaoDich;
    }

    public void setGiaoDich(GiaoDich giaoDich) {
        this.giaoDich = giaoDich;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public LoaiNganSach getLoaiNganSach() {
        return loaiNganSach;
    }

    public void setLoaiNganSach(LoaiNganSach loaiNganSach) {
        this.loaiNganSach = loaiNganSach;
    }
}
