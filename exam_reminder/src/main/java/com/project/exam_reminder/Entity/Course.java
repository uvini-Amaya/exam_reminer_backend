package com.project.exam_reminder.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "course_Table")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courseId")
    private int courseId;
    private String course;
    private String acYear;
    private String level;
}
