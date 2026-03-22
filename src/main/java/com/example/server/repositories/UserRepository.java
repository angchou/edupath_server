package com.example.server.repositories;

import com.example.server.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @EntityGraph(attributePaths = {"userRole", "userRole.role"})
    Optional<User> findByUserEmail(String email);

    @EntityGraph(attributePaths = {"userRole", "userRole.role"})
    List<User> findDistinctByUserRole_RoleRoleIdIn(List<Integer> roles);

    @EntityGraph(attributePaths = {"userRole", "userRole.role"})
    @Query("""
        SELECT DISTINCT u FROM User u
        JOIN u.userRole ur
        JOIN ur.role r
        WHERE u.userStatus = :status
        AND r.roleId IN :roles
    """)
    List<User> findByUserStatus(Integer status, List<Integer> roles);

    boolean existsByUserEmail(String email);

    void deleteByUserEmail(String email);
}
