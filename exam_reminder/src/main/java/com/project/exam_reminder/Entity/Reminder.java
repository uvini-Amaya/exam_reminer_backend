package com.project.exam_reminder.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "reminder_table")

public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reminderId")
    private int reminderId;
/*    private int lecId;
    private int examId;*/
    @ManyToOne
    @JoinColumn(name = "lecId")
    private Lecture lecId;

    @ManyToOne
    @JoinColumn(name = "examId")
    private Exam exmId;
    /*@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "lecId",referencedColumnName = "lecId")
    private Lecturer lec;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "examId",referencedColumnName = "examId")
    private Exam exam;*/
}
