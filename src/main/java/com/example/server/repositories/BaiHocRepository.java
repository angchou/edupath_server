package com.example.server.repositories;

import com.example.server.entities.BaiHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaiHocRepository extends JpaRepository<BaiHoc, String> {
    List<BaiHoc> findByKhoaHoc_KhoaHocIDOrderBySttAsc(String khoaHocID);
    List<BaiHoc> findTop2ByKhoaHoc_KhoaHocIDOrderBySttAsc(String khoaHocID);

    @Query("SELECT COALESCE(MAX(b.stt), 0) FROM BaiHoc b WHERE b.khoaHoc.khoaHocID = :khoaHocID")
    int findMaxSttByKhoaHoc(@Param("khoaHocID") String khoaHocID);
}
