package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Course {
    @Id
    private String courseCode;
    private String course_name;

}
