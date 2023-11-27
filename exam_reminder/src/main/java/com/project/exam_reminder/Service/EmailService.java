package com.project.exam_reminder.Service;


import com.project.exam_reminder.DTO.ExamReqDTO;
import com.project.exam_reminder.Repo.LectureRepo;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private LectureRepo lectureRepo;

    @Autowired
    private LectureService lectureService;


    public void sendSimpleEmail(ExamReqDTO examReqDTO){
        int lecId = examReqDTO.getLectureId();
        String lecEmail = lectureRepo.getEmailByLecId(lecId);

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {

            helper.setTo(lecEmail);
            helper.setSubject("Exam Reminder");
            helper.setText("Dear Sir/Madam,\n\n"
                    + "This is a reminder for the upcoming exam:\n\n"
                    + "Exam Details:\n"
                    + "Start Time: " + examReqDTO.getStime() + "\n"
                    + "End Time: " + examReqDTO.getEtime() + "\n"
                    + "Date: " + examReqDTO.getDate() + "\n"
                    + "Venue: " + examReqDTO.getVenue());


            javaMailSender.send(message);

            System.out.println("Email sent successfully!");

        }catch (Exception e){
            System.out.println("Error sending email: " + e.toString());

        }




    }


}
