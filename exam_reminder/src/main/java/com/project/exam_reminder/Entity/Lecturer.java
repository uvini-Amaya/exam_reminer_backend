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
@Data

public class Lecturer {
    

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "lecId")
        private String lecId;
        private String lecName;
        private String lecEmail;
        private String lecContact ;
        private String lecPassword;

        @ManyToOne
        @JoinColumn(name = "courseId")
        private String courseId;



}




