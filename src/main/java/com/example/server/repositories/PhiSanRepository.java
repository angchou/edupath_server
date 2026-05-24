package com.example.server.repositories;

import com.example.server.entities.PhiSan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface PhiSanRepository extends JpaRepository<PhiSan, String> {
    @Query("SELECT COALESCE(SUM(ps.soTienPhiSan), 0) FROM PhiSan ps " +
            "JOIN ps.giaoDich gd " +
            "JOIN gd.khoaHoc kh " +
            "WHERE kh.nguoiHuongDan.userID = :userID AND gd.trangThai = 1")
    BigDecimal sumSoTienPhiSanByNguoiHuongDan(@Param("userID") String userID);

    Optional<PhiSan> findByGiaoDich_GiaoDichID(String giaoDichID);
}
