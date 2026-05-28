package com.example.server.repositories;

import com.example.server.entities.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, String> {
    @Query("SELECT nv FROM NhanVien nv " +
            "WHERE NOT EXISTS (" +
            "    SELECT ur FROM UserRole ur " +
            "    WHERE ur.user.userID = nv.user.userID " +
            "    AND ur.role.roleID = :roleId" +
            ")")
    List<NhanVien> findByRoleIdNot(@Param("roleId") String roleId);

    @Query("SELECT nv FROM NhanVien nv " +
            "WHERE NOT EXISTS (" +
            "    SELECT ur FROM UserRole ur " +
            "    WHERE ur.user.userID = nv.user.userID " +
            "    AND ur.role.roleID = :roleId" +
            ") AND nv.user.trangThai = :trangThai")
    List<NhanVien> findByRoleIdNotAndTrangThai(@Param("roleId") String roleId, @Param("trangThai") Integer trangThai);

    List<NhanVien> findByUser_TrangThai(Integer trangThai);
    List<NhanVien> findByUser_NgayTao(LocalDate ngayTao);
    Optional<NhanVien> findByUser_UserID(String userID);
}
