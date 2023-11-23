package com.project.exam_reminder.Repo;

import com.project.exam_reminder.Entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LectureRepo extends JpaRepository<Lecture, Integer> {

    @Query(value = "SELECT lecemail FROM Lecture_table WHERE lec_id = ?1", nativeQuery = true)
    String getEmailByLecId(@Param(value = "lec_id") int lec_id);
}
