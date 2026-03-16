package com.example.server.services;

import com.example.server.dto.responses.CourseViewResponse;
import com.example.server.entities.Course;
import com.example.server.mappers.CourseMapper;
import com.example.server.repositories.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CourseService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private CourseRepository courseRepository;

    // Learner, mentor
    public List<CourseViewResponse> getNormalCourse() {

        List<Course> courses = courseRepository.findByCourseStatus(1);

        return courses
                .stream()
                .map(CourseMapper::toViewResponse)
                .toList();

    }


}
