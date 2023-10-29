package com.project.exam_reminder.Service;
import com.project.exam_reminder.DTO.ExamReqDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Entity.Exam;
import com.project.exam_reminder.Entity.Lecturer;
import com.project.exam_reminder.Repo.CourseRepo;
import com.project.exam_reminder.Repo.ExamRepo;
import com.project.exam_reminder.Repo.LectureRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;

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


    public Exam createExam(ExamReqDTO examReqDTO){

        Course course = courseRepo.getReferenceById(examReqDTO.getCourseId());
        Lecturer lecturer = lectureRepo.getReferenceById(examReqDTO.getLecId());

        LocalDate date = LocalDate.parse(examReqDTO.getDate());
        LocalTime time = LocalTime.parse(examReqDTO.getTime());

        Exam exam = new Exam();
        exam.setCourseId(course);
        exam.setVenue(examReqDTO.getVenue());
        exam.setDate(date);
        exam.setTime(time);
        exam.setLecId(lecturer);

        scheduleReminder(exam, examReqDTO);

        examRepo.save(exam);

        return exam;
    }

    private void scheduleReminder(Exam exam , ExamReqDTO examReqDTO){
        LocalDateTime examDT = LocalDateTime.of(exam.getDate(), exam.getTime());
        LocalDateTime reminderDT = examDT.minusHours(24);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                reminderMail(exam, examReqDTO);
            }
        },Date.from(reminderDT.atZone(ZoneId.systemDefault()).toInstant()));
    }


    private void reminderMail(Exam exam, ExamReqDTO examReqDTO){
        Course courseData=courseRepo.getReferenceById(examReqDTO.getCourseId());
        Lecturer lecturerData = lectureRepo.getReferenceById(examReqDTO.getLecId());

        String subject = "Reminder for Course: " + courseData.getCourseName();
        String messege = "You have a Exam Schedule for tommorow. Details:\n" +
                "Course:" + courseData.getCourseName() + "\n" +
                "Date:" + examReqDTO.getDate() + "\n" +
                "Time:" + examReqDTO.getTime() + "\n" +
                "Venue:" + examReqDTO.getVenue();

        emailService.sendEmail(lecturerData.getLecemail() , subject, messege );


    }


}
