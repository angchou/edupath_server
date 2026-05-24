package com.example.server.repositories;

import com.example.server.dto.request.RoadmapStepRequest;
import com.example.server.entities.DauViecLoTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DauViecRepository extends JpaRepository<DauViecLoTrinh, String> {
    List<DauViecLoTrinh> findByLoTrinh_LoTrinhIDOrderByStt(String loTrinhID);

    List<DauViecLoTrinh> findByLoTrinh_LoTrinhID(String loTrinhID);

}
