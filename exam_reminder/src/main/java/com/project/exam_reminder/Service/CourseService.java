package com.project.exam_reminder.Service;

import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.DTO.CourseDTO;
import jakarta.persistence.EntityNotFoundException;
import com.project.exam_reminder.Repo.CourseRepo;
public class CourseService {
    public Course getCourseDetails(CourseDTO courseDTO) {
        return null;
    }

    public Course saveCourseDetails(CourseDTO courseDto) {
        Course course = courseRepo.findById(CourseDTO.getCourseId())
                .orElseThrow(()-> new EntityNotFoundException("Course not found"));




        Course crs = new Course();
        crs.setCourseId(courseDTO.getCorseId());
        crs.setCourse(courseDTO.getCourse());
        crs.setAcYear(courseDTO.getAcYear());
        crs.setLevel(courseDTO.getLevel());



        return courseRepo.save(crs);
    }

    public Course updateCourseDetails(CourseDTO course__dto) {
        return null;
    }

    public Course deleteCourseDetails(CourseDTO crseDto) {
        return null;
    }
}
