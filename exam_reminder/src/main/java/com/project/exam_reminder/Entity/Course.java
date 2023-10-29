package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Course {
    @Id
    private String courseId;
    private String courseName;

}
