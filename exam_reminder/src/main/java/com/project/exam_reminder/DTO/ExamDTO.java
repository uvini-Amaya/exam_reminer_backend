package com.project.exam_reminder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamDTO {
    private int examId;
    private String time;
    private String date;
    private String coursecode;
}
