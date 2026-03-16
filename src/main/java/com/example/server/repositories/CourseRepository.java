package com.example.server.repositories;

import com.example.server.entities.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {

    @EntityGraph(attributePaths = {"mentor", "mentor.user"})
    List<Course> findByCourseStatus(Integer courseStatus);

}
