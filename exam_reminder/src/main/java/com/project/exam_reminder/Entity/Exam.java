package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data

public class Exam {
    @Id
    private String exam_id;
    private String Acc_year;
    private String sem;
    private String level ;


}
