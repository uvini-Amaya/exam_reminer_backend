package com.project.exam_reminder.Repo;

import com.project.exam_reminder.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface CourseRepo extends JpaRepository<Course, Integer> {

    Course findByCourseName(String courseName);


}
