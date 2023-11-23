package com.project.exam_reminder.Controller;
import com.project.exam_reminder.DTO.ExamReqDTO;
import com.project.exam_reminder.Entity.Exam;
import com.project.exam_reminder.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"api/exam_reminder/exam"})
@CrossOrigin
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/createexam")
    public ResponseEntity<?> createExam(@RequestBody ExamReqDTO examReqDTO){
        Exam exam = examService.createExam(examReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exam);
    }
}
