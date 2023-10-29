package com.project.exam_reminder.Service;


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

    public void sendEmail(String toEmail,String subject, String body){
        SimpleMailMessage messege = new SimpleMailMessage();
        messege.setFrom("s17061@sci.pdn.ac.lk");
        messege.setTo(toEmail);
        messege.setText(body);
        messege.setSubject(subject);

        javaMailSender.send(messege);

    }
}
