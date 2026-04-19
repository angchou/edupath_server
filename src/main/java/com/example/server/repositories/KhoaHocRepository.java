package com.example.server.repositories;

import com.example.server.entities.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, String> {

    List<KhoaHoc> findByTinhTrang(int tinhTrang);

    List<KhoaHoc> findByNguoiHuongDan_UserID(String userID);

}
