package com.project.exam_reminder.Service;

import com.project.exam_reminder.DTO.CourseDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Repo.CourseRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Handler;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    public Course getCourseDetails(int courseId) {

        return courseRepo.findById(courseId).orElse(null);
    }

    public Course saveCourseDetails(CourseDTO courseDto) {
        if (courseDto == null){
            return null;
        }else {

            Course crs = new Course();

            crs.setCourseId(courseDto.getCourseId());
            crs.setCourse(courseDto.getCourse());
            crs.setAcYear(courseDto.getAcYear());
            crs.setLevel(courseDto.getLevel());

            return courseRepo.save(crs);
        }

    }

    public Course updateCourseDetails(CourseDTO course__dto) {
        if (course__dto == null){
            return null;
        }

        if (course__dto.getCourseId() <= 0){
            return null;
        }
        Course checkCourse = courseRepo.findById(course__dto.getCourseId()).orElse(null);
        if(checkCourse == null){
            return null;
        }
        checkCourse.setCourse(course__dto.getCourse());
        checkCourse.setAcYear(course__dto.getAcYear());
        checkCourse.setLevel(course__dto.getLevel());

        return courseRepo.save(checkCourse);
    }

    public String deleteCourseDetails(int courseId) {

        Course checkCourse = courseRepo.findById(courseId).orElse(null);

        if (checkCourse == null){
            return "Course not found";
        }
        courseRepo.deleteById(courseId);

        return "Course deleted successfully";
    }
}
