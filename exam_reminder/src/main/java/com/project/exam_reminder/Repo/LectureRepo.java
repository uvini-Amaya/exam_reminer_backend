package com.project.exam_reminder.Repo;

import com.project.exam_reminder.Entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface LectureRepo extends JpaRepository<Lecturer, Integer> {
}
