package com.project.exam_reminder.Service;

import com.project.exam_reminder.DTO.CourseDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Repo.CourseRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Handler;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Course getCourseDetails(int courseId) {
        try{
            return courseRepo.findById(courseId).orElse(null);
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }


    }

    public Course saveCourseDetails(CourseDTO courseDto) {
        try{
            if (courseDto == null){
                return null;
            }else {

                Course crs = new Course();

                crs.setCourseId(courseDto.getCourseId());
                crs.setCourseName(courseDto.getCourseName());
                crs.setAcYear(courseDto.getAcYear());
                crs.setLevel(courseDto.getLevel());

                return courseRepo.save(crs);
            }
        }catch(Exception e){
            return null;
        }


    }

    public Course updateCourseDetails(CourseDTO course__dto) {
        try {
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
            checkCourse.setCourseName(course__dto.getCourseName());
            checkCourse.setAcYear(course__dto.getAcYear());
            checkCourse.setLevel(course__dto.getLevel());

            return courseRepo.save(checkCourse);
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }

    }

    public String deleteCourseDetails(int courseId) {
        try {
            if (courseRepo.existsById(courseId)) {
                courseRepo.deleteById(courseId);
                return "Course deleted successfully";
            } else {
                return "Course not found";
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }

    }

    public List<CourseDTO> getAllCourseDetails() {
        try {
            List<Course> list=courseRepo.findAll();
            return modelMapper.map(list, new TypeToken<List<CourseDTO>>(){}.getType());
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }
}
