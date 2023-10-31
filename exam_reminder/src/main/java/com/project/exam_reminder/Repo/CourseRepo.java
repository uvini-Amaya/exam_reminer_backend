package com.project.exam_reminder.Repo;

import com.project.exam_reminder.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@EnableJpaRepositories

public interface CourseRepo extends JpaRepository<Course, UUID> {
//    public Optional<Object> findById(Object lecId) {
//    }

    public default Course save(Course course) {
        return null;
    }
}