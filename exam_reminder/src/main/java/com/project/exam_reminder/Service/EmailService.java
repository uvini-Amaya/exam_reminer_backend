package com.project.exam_reminder.Service;


import com.project.exam_reminder.Repo.LectureRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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


    public boolean sendSimpleEmail(int lec_id,String subject, String body){
        boolean send = false;

        try {
            String email = lectureRepo.getEmailByLecId(lec_id);
            if (email!=null){
                SimpleMailMessage messege = new SimpleMailMessage();

                messege.setFrom("s17061@sci.pdn.ac.lk");
                messege.setTo(email);
                messege.setText(body);
                messege.setSubject(subject);

                javaMailSender.send(messege);
                System.out.println(body);
                System.out.println(subject);

                send = true;
            }
            return send;

        }catch (Exception e){
            System.out.println(e.toString());
            return send;
        }



    }
}
