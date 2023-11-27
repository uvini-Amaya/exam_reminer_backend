package com.project.exam_reminder.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "lecture_table")
@NoArgsConstructor
public class Lecture {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "lecId")
        private int lecId;
        private String lecName;
        private String lecEmail;
        private String lecContact ;
        private String lecPassword;


        @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
        @JsonIgnore
        private List<Exam> exams;

}
