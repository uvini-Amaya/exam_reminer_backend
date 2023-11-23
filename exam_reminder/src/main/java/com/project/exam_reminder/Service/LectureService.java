package com.project.exam_reminder.Service;

import com.project.exam_reminder.DTO.LectureDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Entity.Lecture;
import com.project.exam_reminder.Repo.LectureRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class LectureService {
    @Autowired
    private LectureRepo lectureRepo;

    @Autowired
    private ModelMapper modelMapper;

    public void getAllLeccturers() {

    }

    public Lecture getLecturerDetails(int lecId) {

        return lectureRepo.findById(lecId).orElse(null);
    }

    public Lecture saveLecturerDetails(LectureDTO lectureDTO) {

        if (lectureDTO == null){
            return null;
        }

        Lecture lect = new Lecture();
        lect.setLecId(lectureDTO.getLecId());
        lect.setLecName(lectureDTO.getLecName());
        lect.setLecContact(lectureDTO.getLecContact());
        lect.setLecEmail(lectureDTO.getLecEmail());
        lect.setLecPassword(lectureDTO.getLecPassword());


        return lectureRepo.save(lect);
    }

    public Lecture updateLecturerDetails(LectureDTO lecturer__dto) {
        if (lecturer__dto == null){
            return null;
        }

        if (lecturer__dto.getLecId() <= 0){
            return null;
        }
        Lecture updateLecture = lectureRepo.findById(lecturer__dto.getLecId()).orElse(null);
        if(updateLecture == null){
            return null;
        }
        updateLecture.setLecName(lecturer__dto.getLecName());
        updateLecture.setLecPassword(lecturer__dto.getLecPassword());
        updateLecture.setLecEmail(lecturer__dto.getLecEmail());
        updateLecture.setLecContact(lecturer__dto.getLecContact());


        return lectureRepo.save(updateLecture);
    }


    public String deleteLecturerDetails(int lecId){
        Lecture checkLec = lectureRepo.findById(lecId).orElse(null);

        if (checkLec == null){
            return "Lecture not found";
        }

        lectureRepo.deleteById(lecId);

        return "Lecturer deleted successfully";
    }



}
