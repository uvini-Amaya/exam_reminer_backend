package com.project.exam_reminder.Controller;

import com.project.exam_reminder.Repo.LectureRepo;
import com.project.exam_reminder.Service.EmailService;
import com.project.exam_reminder.Service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping({"api/examreminder/email"})
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private LectureRepo lectureRepo;

    @Autowired
    private LectureService lectureService;

    @PostMapping("/sendmail/{lec_id}")
    public ResponseEntity<?> sendMail(@PathVariable int lec_id){

        /*Lecturer lec = lectureService.getLectureById(lec_id);*/

            Map<String,Object> map = new LinkedHashMap<String,Object>();
            boolean sent = emailService.sendSimpleEmail(lec_id, "Messege","course details");

            if (sent){
                map.put("status", 1);
                map.put("data", sent);
                return new ResponseEntity<>(map, HttpStatus.OK);

            }else{
                map.clear();
                map.put("status", 0);
                map.put("message", "Mail not send");
                return new ResponseEntity<>(map, HttpStatus.OK);
        }


    }

}
