package com.project.exam_reminder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDTO {
    private int examId;
    private LocalTime stime;
    private LocalTime etime;
    private LocalDate date;
    private String venue;
    private String courseName;
    private int courseId;
    private int lectureId;
}
