package com.example.server.repositories;

import com.example.server.entities.ThamGiaKH;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ThamGiaKHRepository extends JpaRepository<ThamGiaKH, String> {
    Boolean existsByKhoaHoc_KhoaHocIDAndHocVien_UserID(String khoaHocID, String hocVienID);

    Optional<ThamGiaKH> findByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanGreaterThanEqual(
            String khoaHocID,
            String hocVienID,
            LocalDate now
    );

    @Query("""
    SELECT t\s
    FROM ThamGiaKH t\s
    WHERE t.hocVien.userID = :userID\s
      AND t.ngayHetHan >= :now
      AND t.khoaHoc.tinhTrang NOT IN (0, 1, 2)
    """)
    List<ThamGiaKH> findActiveCourses(@Param("userID") String userID, @Param("now") LocalDate now);
    List<ThamGiaKH> findByHocVien_UserID(String userID);

    boolean existsByKhoaHoc_KhoaHocIDAndHocVien_UserIDAndNgayHetHanAfter(String khoaHocID, String userID, LocalDate date);
    boolean existsByKhoaHoc_NguoiHuongDan_UserIDAndHocVien_UserIDAndNgayHetHanAfter(String nguoiHuongSanID, String userID, LocalDate date);

    @Query("SELECT DISTINCT t.hocVien.userID FROM ThamGiaKH t WHERE t.ngayHetHan >= :now")
    List<String> findActiveHocVienIDs(@Param("now") LocalDate now);

}
