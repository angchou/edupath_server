package com.example.server.repositories;

import com.example.server.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByEmail(String email);
    List<Users> findByTrangThai(Integer trangThai);
    boolean existsByEmail(String email);

    @Query("SELECT u FROM Users u " +
            "LEFT JOIN FETCH u.nguoiHuongDan " +
            "LEFT JOIN FETCH u.hocVien " +
            "WHERE u.trangThai = :trangThai")
    List<Users> findByTrangThaiWithRoles(@Param("trangThai") Integer trangThai);
}
