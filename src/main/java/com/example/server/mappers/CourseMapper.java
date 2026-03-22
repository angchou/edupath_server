package com.example.server.mappers;

import com.example.server.dto.responses.CourseViewResponse;
import com.example.server.dto.summaries.MentorSummaryResponse;
import com.example.server.entities.Course;
import com.example.server.entities.Mentor;
import com.example.server.entities.User;

public class CourseMapper {

    public static CourseViewResponse toViewResponse(Course course) {

        CourseViewResponse res = new CourseViewResponse();

        res.setCourseId(course.getCourseId());
        res.setCourseName(course.getCourseName());
        res.setCourseCreatedAt(course.getCourseCreatedAt());
        res.setCourseType(course.getCourseType());
        res.setCourseDescription(course.getCourseDescription());
        res.setCoursePrice(course.getCoursePrice());
        res.setCourseStatus(course.getCourseStatus());
        Mentor mentor = course.getMentor();
        User user = mentor.getUser();

        MentorSummaryResponse mentorRes = new MentorSummaryResponse();
        mentorRes.setMentorId(mentor.getMentorId());
        mentorRes.setMentorUserName(user.getUserName());
        mentorRes.setMentorEmail(user.getUserEmail());
        mentorRes.setMentorStatus(user.getUserStatus());
        mentorRes.setMentorCreatedAt(user.getUserCreatedAt());
        mentorRes.setMentorAverageRating(mentor.getAverageRating());

        res.setMentorSummaryResponse(mentorRes);

        return res;

    }

}
