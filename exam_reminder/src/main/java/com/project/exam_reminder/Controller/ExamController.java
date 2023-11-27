package com.project.exam_reminder.Controller;
import com.project.exam_reminder.DTO.ExamDTO;
import com.project.exam_reminder.DTO.ExamReqDTO;
import com.project.exam_reminder.DTO.TaskDTO;
import com.project.exam_reminder.Entity.Exam;
import com.project.exam_reminder.Repo.LectureRepo;
import com.project.exam_reminder.Service.EmailService;
import com.project.exam_reminder.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/exam_reminder/exam"})
@CrossOrigin
public class ExamController {
    @Autowired
    private ExamService examService;

    @Autowired
    private LectureRepo lectureRepo;

    @Autowired
    private EmailService emailService;

    @PostMapping("/createexam")
    public ResponseEntity<Exam> createExam(@RequestBody ExamReqDTO examReqDTO){
        Exam exam = examService.createExam(examReqDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(exam);
    }

    @GetMapping("/getAllExam")
    public ResponseEntity<List<ExamReqDTO>> getAll(){
        List<ExamReqDTO> exams = examService.getAllExam();
        if (!exams.isEmpty()){
            return new ResponseEntity<>(exams , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/deleteExam/{examId}")
    public ResponseEntity<String> deleteExams(@PathVariable int examId){
        String deleted = examService.deleteExam(examId);

        if (deleted.equals("Lecturer deleted successfully")){
            return ResponseEntity.ok(deleted);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getExamByLecId/{lecId}")
    public ResponseEntity<?> getExamByLecId(@PathVariable int lecId){
        List<ExamDTO> examLec = examService.getExamByLecId(lecId);

        if (!examLec.isEmpty()){

            return new ResponseEntity<>(examLec, HttpStatus.OK);
        }
        return new ResponseEntity<>("No exams found for the given lecturer ID", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody ExamReqDTO examReqDTO) {
        emailService.sendSimpleEmail(examReqDTO);
    }
}
