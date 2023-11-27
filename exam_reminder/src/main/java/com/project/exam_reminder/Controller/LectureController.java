package com.project.exam_reminder.Controller;

import com.project.exam_reminder.DTO.LectureDTO;
import com.project.exam_reminder.Entity.Lecture;
import com.project.exam_reminder.Service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/exam_reminder/lecturer"})
@CrossOrigin
public class LectureController {

    @Autowired
    private LectureService lecturerService;

    @GetMapping("/getLecturerDetails/{lecId}")
    public ResponseEntity<Lecture> getLecturerDetails(@PathVariable int lecId){
        Lecture lecturer = lecturerService.getLecturerDetails(lecId);
        if (lecturer != null) {
            return ResponseEntity.ok(lecturer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAllLecturerDetails")
    public ResponseEntity<List<LectureDTO>> getAllLecturerDetails(){
        List<LectureDTO> lecturer = lecturerService.getAllLecturerDetails();
        if (lecturer != null) {
            return ResponseEntity.ok(lecturer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/saveLecturerDetails")
    public ResponseEntity<Lecture> saveLecturerDetails(@RequestBody LectureDTO lecturer_DTO){
        Lecture lec = lecturerService.saveLecturerDetails(lecturer_DTO);
        if (lec != null) {
            return ResponseEntity.ok(lec);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/updateLecturerDetails")
    public ResponseEntity<Lecture> updateLecturerDetails(@RequestBody LectureDTO lecturer__DTO){
        Lecture lect = lecturerService.updateLecturerDetails(lecturer__DTO);
        if (lect != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(lect);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteLecturerDetails/{lecId}")
    public ResponseEntity<String> deleteLecturerDetails(@PathVariable int lecId){
        String deleted = lecturerService.deleteLecturerDetails(lecId);

        if (deleted.equals("Lecturer deleted successfully")){
            return ResponseEntity.ok(deleted);
        }
        return ResponseEntity.notFound().build();
    }
}
