
package com.project.exam_reminder.Controller;
import com.project.exam_reminder.DTO.LecturerDTO;
import com.project.exam_reminder.Entity.Lecturer;
import com.project.exam_reminder.Service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping({"api/exam_reminder/lecturer"})
    @CrossOrigin
    public class LecturerController {
        @Autowired
        private LecturerService lecturerService;

        @GetMapping("/getLecturerDetails")
        public ResponseEntity<Lecturer> getLecturerDetails(@RequestBody LecturerDTO lecturerDTO){
            Lecturer lecturer = lecturerService.getLecturerDetails(lecturerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(lecturer);
        }

        @PostMapping("/saveLecturerDetails")
        public ResponseEntity<Lecturer> saveLecturerDetails(@RequestBody LecturerDTO lecturer_DTO){
            Lecturer lec = lecturerService.saveLecturerDetails(lecturer_DTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(lec);
        }

        @PutMapping("/updateLecturerDetails")
        public ResponseEntity<Lecturer> updateLecturerDetails(@RequestBody LecturerDTO lecturer__DTO){
            Lecturer lect = lecturerService.updateLecturerDetails(lecturer__DTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(lect);
        }

        @DeleteMapping("/deleteLecturerDetails")
        public ResponseEntity<Lecturer> deleteLecturerDetails(@RequestBody LecturerDTO lect_DTO){
            Lecturer lct = lecturerService.deleteLecturerDetails(lect_DTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(lct);
        }

    }