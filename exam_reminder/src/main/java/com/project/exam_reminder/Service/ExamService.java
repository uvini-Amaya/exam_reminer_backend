package com.project.exam_reminder.Service;
import com.project.exam_reminder.DTO.ExamReqDTO;
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

        if (examReqDTO == null) {

            return null;
        }else {
            Course course = courseRepo.getReferenceById(examReqDTO.getCourseId());
            Lecture lecturer = lectureRepo.getReferenceById(examReqDTO.getLecId());

            LocalDate date = (examReqDTO.getDate() != null) ? LocalDate.parse(examReqDTO.getDate()) : null;
            LocalTime stime = (examReqDTO.getStime() != null) ? LocalTime.parse(examReqDTO.getStime()) : null;
            LocalTime etime = (examReqDTO.getEtime() != null) ? LocalTime.parse(examReqDTO.getEtime()) : null;

            Exam exam = new Exam();
            exam.setCourseId(course);
            exam.setVenue(examReqDTO.getVenue());
            exam.setDate(date);
            exam.setStime(stime);
            exam.setEtime(etime);
            exam.setLecId(lecturer);

            /*scheduleReminder(exam, examReqDTO);*/

            examRepo.save(exam);

            return exam;
        }


    }

    private void scheduleReminder(@NotNull Exam exam , ExamReqDTO examReqDTO){
        LocalDateTime examDT = LocalDateTime.of(exam.getDate(), exam.getStime());
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
        Lecture lecturerData = lectureRepo.getReferenceById(examReqDTO.getLecId());

        String subject = "Reminder for Course: " + courseData.getCourse();
        String messege = "You have a Exam Schedule for tommorow. Details:\n" +
                "Course:" + courseData.getCourse() + "\n" +
                "Date:" + examReqDTO.getDate() + "\n" +
                "Time:" + examReqDTO.getStime() + "\n" +
                "Venue:" + examReqDTO.getVenue();

        /*emailService.sendSimpleEmail(lecturerData.getLecemail() , subject, messege );
        System.out.println(messege);*/


    }


}
