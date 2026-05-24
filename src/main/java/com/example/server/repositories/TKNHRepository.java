package com.example.server.repositories;

import com.example.server.entities.TaiKhoanNganHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TKNHRepository extends JpaRepository<TaiKhoanNganHang, String> {
    List<TaiKhoanNganHang> findByNguoiHuongDan_UserID(String userID);
}
