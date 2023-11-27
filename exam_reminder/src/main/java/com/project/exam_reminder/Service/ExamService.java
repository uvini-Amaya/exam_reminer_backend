package com.project.exam_reminder.Service;
import com.project.exam_reminder.DTO.*;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Entity.Exam;
import com.project.exam_reminder.Entity.Lecture;
import com.project.exam_reminder.Repo.CourseRepo;
import com.project.exam_reminder.Repo.ExamRepo;
import com.project.exam_reminder.Repo.LectureRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
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
    @Autowired
    private EmailService emailService;


    public List<ExamReqDTO> getAllExam(){

        try {
            List<Exam> exams = examRepo.findAll();
            if (exams != null && !exams.isEmpty()){
                return modelMapper.map(exams, new TypeToken<List<ExamDTO>>(){}.getType());
            }
            return Collections.emptyList();
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    public List<ExamDTO> getExamByLecId(int lecId) {
        try {
            System.out.println("Provided lecturer ID: " + lecId);

            List<Exam> exams = examRepo.findByLecture_LecId(lecId);

            if (exams != null) {
                System.out.println("Number of exams found: " + exams.size());

                if (!exams.isEmpty()) {
                    return modelMapper.map(exams, new TypeToken<List<ExamDTO>>() {}.getType());
                } else {
                    System.out.println("No exams found for the given lecturer ID.");
                    return Collections.emptyList();
                }
            } else {
                System.out.println("Exams list is null.");
                return Collections.emptyList();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
            return Collections.emptyList();
        }
    }


    public String deleteExam(int examId) {
        try {
            if (examRepo.existsById(examId)) {
                examRepo.deleteById(examId);
                return "Exam deleted successfully";
            } else {
                return "Exam not found";
            }
        }catch(Exception e){
            return null;
        }

    }
    public Exam createExam(ExamReqDTO examReqDTO){
        try {
            if (examReqDTO == null) {

                return null;
            }else {

                LocalDate date = (examReqDTO.getDate() != null) ? LocalDate.parse(examReqDTO.getDate()) : null;
                LocalTime stime = (examReqDTO.getStime() != null) ? LocalTime.parse(examReqDTO.getStime()) : null;
                LocalTime etime = (examReqDTO.getEtime() != null) ? LocalTime.parse(examReqDTO.getEtime()) : null;

                Exam exam = new Exam();
                exam.setVenue(examReqDTO.getVenue());
                exam.setDate(date);
                exam.setStime(stime);
                exam.setEtime(etime);

                Course course = courseRepo.findById(examReqDTO.getCourseId()).orElse(null);

                Lecture lecturer = lectureRepo.findById(examReqDTO.getLectureId()).orElse(null);

                exam.setCourse(course);
                exam.setLecture(lecturer);

                examRepo.save(exam);

                return exam;
            }
        }catch(Exception e){
            System.out.println(e.toString());
            return null;
        }
    }



}
