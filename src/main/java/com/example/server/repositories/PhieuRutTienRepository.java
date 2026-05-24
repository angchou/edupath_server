package com.example.server.repositories;

import com.example.server.entities.PhieuRutTien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PhieuRutTienRepository extends JpaRepository<PhieuRutTien, String> {
    List<PhieuRutTien> findByNguoiHuongDan_UserID(String userID);

    @Query("SELECT COALESCE(SUM(p.soTienRut), 0) FROM PhieuRutTien p WHERE p.nguoiHuongDan.userID = :userID")
    BigDecimal sumSoTienRutByUserID(@Param("userID") String userID);
}
