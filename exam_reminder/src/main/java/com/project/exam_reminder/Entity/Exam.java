package com.project.exam_reminder.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Exam_table")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examId")
    private int examId;
    private String time;
    private String date;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Lecturer courseId;
}
