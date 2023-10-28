package com.project.exam_reminder.Entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "Lecture_table")
@NoArgsConstructor
public class Lecturer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "lec_id")
        private int lecid;
        private String lecname;
        private String lecemail;
        private String leccontact;
}
