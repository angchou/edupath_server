package com.example.server.services;

import com.example.server.dto.requests.CreateCourseRequest;
import com.example.server.dto.responses.CourseViewResponse;
import com.example.server.entities.Course;
import com.example.server.entities.Mentor;
import com.example.server.mappers.CourseMapper;
import com.example.server.repositories.CourseRepository;
import com.example.server.repositories.MentorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class CourseService {

    private static final Logger logger = Logger.getLogger(UserService.class.getName());

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MentorRepository mentorRepository;

    // Learner, mentor
    public List<CourseViewResponse> getNormalCourse() {

        List<Course> courses = courseRepository.findByCourseStatus(1);

        return courses
                .stream()
                .map(CourseMapper::toViewResponse)
                .toList();

    }

    @Transactional
    public void createNewCourse(CreateCourseRequest request) {
        // Find mentor
        Mentor mentor = mentorRepository.findById(request.getMentor_id())
                .orElseThrow(() -> new RuntimeException("Mentor not Found!"));

        // Create new course
        Course course = new Course();

        course.setCourseName(request.getCourse_name());
        course.setCourseType(request.getCourse_type());
        course.setCourseDescription(request.getCourse_description());
        course.setCoursePrice(request.getCourse_price());
        course.setCourseSize(request.getCourse_size());
        course.setCourseCreatedAt(LocalDateTime.now());
        course.setCourseStatus(1);

        course.setMentor(mentor);

        courseRepository.save(course);
    }

}
