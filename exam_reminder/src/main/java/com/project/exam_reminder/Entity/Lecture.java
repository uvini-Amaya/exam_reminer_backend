package com.project.exam_reminder.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Lecture_table")
@NoArgsConstructor
public class Lecture {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "lec_id")
        private int lecId;
        private String lecName;
        private String lecEmail;
        private String lecContact ;
        private String lecPassword;

        @ManyToOne
        @JoinColumn(name = "course_id")
        private Course courseId;

}
