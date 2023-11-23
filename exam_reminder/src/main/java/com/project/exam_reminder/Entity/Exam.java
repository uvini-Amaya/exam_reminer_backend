package com.project.exam_reminder.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalTime stime;
    private LocalTime etime;
    private LocalDate date;
    private String venue;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lec_id")
    private Lecture lecId;

}
