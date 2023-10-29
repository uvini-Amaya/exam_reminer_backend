package com.project.exam_reminder.Service;

import com.project.exam_reminder.DTO.LecturerDTO;
import com.project.exam_reminder.Entity.Lecturer;
import com.project.exam_reminder.Repo.CourseRepo;
import com.project.exam_reminder.Repo.ExamRepo;
import com.project.exam_reminder.Repo.LecturerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepo lecturerRepo;

//    @Autowired
//    private CourseRepo courseRepo;

    @Autowired
    private ModelMapper modelMapper;




    public void getAllLeccturers() {
    }

    public Lecturer getLecturerDetails(LecturerDTO lecturerDTO) {
        return null;
    }

    public Lecturer saveLecturerDetails(LecturerDTO lecturerDTO) {
        Lecturer lecturer = lecturerRepo.findById(LecturerDTO.getLecId())
                .orElseThrow(()-> new EntityNotFoundException("Lecture not found"));



        Lecturer lect = new Lecturer();
        lecturer.setLecId(lecturerDTO.getLecId());
        lecturer.setLecName(lecturerDTO.getLecName());
        lecturer.setLecContact(lecturerDTO.getLecContact());
        lecturer.setLecEmail(lecturerDTO.getLecEmail());
        lecturer.setLecPassword(lecturerDTO.getLecPassword());


        return lecturerRepo.save(lecturer);
    }

    public Lecturer updateLecturerDetails(LecturerDTO lecturer__dto) {
        return null;
    }

    public Lecturer deleteLecturerDetails(LecturerDTO lectDto) {
        return null;
    }
}







}