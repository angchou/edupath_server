package com.example.server.repositories;

import com.example.server.entities.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, String> {
    List<KhoaHoc> findByTinhTrang(int tinhTrang);
    List<KhoaHoc> findByTinhTrangIn(List<Integer> tinhTrang);

    List<KhoaHoc> findByNguoiHuongDan_UserID(String userID);

    Boolean existsByKhoaHocIDAndNguoiHuongDan_UserID(String khoaHocID, String userID);

    @Query("SELECT k.tinhTrang FROM KhoaHoc k WHERE k.khoaHocID = :khoaHocID")
    Integer findTinhTrangByKhoaHocID(@Param("khoaHocID") String khoaHocID);

    @Query(value = "SELECT func_get_current_students(:khoaHocId) FROM dual", nativeQuery = true)
    int getCurrentStudentsCount(@Param("khoaHocId") String khoaHocId);
}
