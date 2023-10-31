package com.project.exam_reminder.Controller;

import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.DTO.CourseDTO;
import com.project.exam_reminder.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/exam_reminder/lecturer"})
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourseDetails")
    public ResponseEntity<Course> getCourseDetails(@RequestBody CourseDTO courseDTO){
        Course course = courseService.getCourseDetails(courseDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @PostMapping("/saveCourseDetails")
    public ResponseEntity<Course> saveCourseDetails(@RequestBody CourseDTO course_DTO){
        Course crs = courseService.saveCourseDetails(course_DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crs);
    }

    @PutMapping("/updateCourseDetails")
    public ResponseEntity<Course> updateCourseDetails(@RequestBody CourseDTO course__DTO){
        Course crse = courseService.updateCourseDetails(course__DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(crse);
    }

    @DeleteMapping("/deleteCourseDetails")
    public ResponseEntity<Course> deleteCourseDetails(@RequestBody CourseDTO crse_DTO){
        Course cors = courseService.deleteCourseDetails(crse_DTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(cors);
    }

}