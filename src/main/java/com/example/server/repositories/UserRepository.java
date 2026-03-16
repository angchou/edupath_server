package com.example.server.repositories;

import com.example.server.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @EntityGraph(attributePaths = {"userRole", "userRole.role"})
    Optional<User> findByUserEmail(String email);

    boolean existsByUserEmail(String email);

    void deleteByUserEmail(String email);
}
