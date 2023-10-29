package com.project.exam_reminder.Service;
import com.project.exam_reminder.DTO.ExamReqDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Entity.Exam;
import com.project.exam_reminder.Entity.Lecturer;
import com.project.exam_reminder.Repo.CourseRepo;
import com.project.exam_reminder.Repo.ExamRepo;
import com.project.exam_reminder.Repo.LectureRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    private ExamRepo examRepo;
    @Autowired
    private LectureRepo lectureRepo;
    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Exam createExam(ExamReqDTO examReqDTO){
        Lecturer lecturer = lectureRepo.findById(examReqDTO.getLecId())
                .orElseThrow(()-> new EntityNotFoundException("Lecture not found"));

        Course course = courseRepo.findById(examReqDTO.getCourseId())
                .orElseThrow(()-> new EntityNotFoundException("Course Not Found"));

        Exam exam = new Exam();
        exam.setCourseId(course);
        exam.setVenue(examReqDTO.getVenue());
        exam.setDate(examReqDTO.getDate());
        exam.setTime(examReqDTO.getTime());
        exam.setLecId(lecturer);

        return examRepo.save(exam);
    }


}
