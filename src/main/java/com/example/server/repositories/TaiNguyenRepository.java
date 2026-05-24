package com.example.server.repositories;

import com.example.server.entities.TaiNguyen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaiNguyenRepository extends JpaRepository<TaiNguyen, String> {
    List<TaiNguyen> findByBaiHoc_BaiHocIDOrderBySttAsc(String baiHocID);

    @Query("SELECT COALESCE(MAX(t.stt), 0) FROM TaiNguyen t WHERE t.baiHoc.baiHocID = :baiHocID")
    int findMaxSttByBaiHoc(@Param("baiHocID") String baiHocID);
}
