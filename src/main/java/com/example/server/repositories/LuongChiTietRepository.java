package com.example.server.repositories;

import com.example.server.entities.LuongChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LuongChiTietRepository extends JpaRepository<LuongChiTiet, String> {

    @Query("SELECT MAX(l.ngayTao) FROM LuongChiTiet l WHERE l.nhanVien.userID = :userId AND l.trangThai = 1 ORDER BY l.ngayTao DESC")
    LocalDate findLatestNgayTaoByUserId(@Param("userId") String userId);

    List<LuongChiTiet> findByNhanVien_UserID(String userID);

}