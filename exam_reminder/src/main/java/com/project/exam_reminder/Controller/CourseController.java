package com.project.exam_reminder.Controller;

import com.project.exam_reminder.DTO.CourseDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Repo.CourseRepo;
import com.project.exam_reminder.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/exam_reminder/course"})
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/getCourseDetails/{courseId}")
    public ResponseEntity<Course> getCourseDetails(@PathVariable int courseId){
        Course course = courseService.getCourseDetails(courseId);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/getAllCourseDetails")
    public ResponseEntity<List<CourseDTO>> getAllCourseDetails(){
        List<CourseDTO> course = courseService.getAllCourseDetails();
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/saveCourseDetails")
    public ResponseEntity<Course> saveCourseDetails(@RequestBody CourseDTO course_DTO){
        Course crs = courseService.saveCourseDetails(course_DTO);
        if (crs != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(crs);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateCourseDetails")
    public ResponseEntity<Course> updateCourseDetails(@RequestBody CourseDTO course__DTO){
        Course crse = courseService.updateCourseDetails(course__DTO);
        if (crse != null) {
            return ResponseEntity.ok(crse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteCourseDetails/{courseId}")
    public ResponseEntity<String> deleteCourseDetails(@PathVariable int courseId){
        String deleted = courseService.deleteCourseDetails(courseId);

        if (deleted.equals("Course deleted successfully")){
            return ResponseEntity.ok(deleted);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

}
