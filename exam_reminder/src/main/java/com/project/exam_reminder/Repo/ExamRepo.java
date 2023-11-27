package com.project.exam_reminder.Repo;

import com.project.exam_reminder.DTO.TaskDTO;
import com.project.exam_reminder.Entity.Course;
import com.project.exam_reminder.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface ExamRepo extends JpaRepository<Exam, Integer> {

    @Query("SELECT t FROM Exam t WHERE t.lecture.lecId = :lecId")
    List<Exam> findByLecture_LecId(@Param("lecId") int lecid);

    @Query("SELECT new com.project.exam_reminder.DTO.ExamDTO(e.examId, e.stime, e.etime, e.date, e.venue, c.courseName) FROM Exam e JOIN e.course c WHERE e.lecture.lecId = :lecId")
    List<TaskDTO> findExamsByLectureIdWithCourseName(@Param("lecId") int lecId);

}
