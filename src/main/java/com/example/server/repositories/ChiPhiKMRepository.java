package com.example.server.repositories;

import com.example.server.entities.ChiPhiKM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiPhiKMRepository extends JpaRepository<ChiPhiKM, String> {
}
