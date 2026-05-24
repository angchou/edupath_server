package com.example.server.repositories;

import com.example.server.entities.NganSach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NganSachRepository extends JpaRepository<NganSach, String> {
}
