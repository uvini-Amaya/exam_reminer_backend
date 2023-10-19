package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;
import java.util.Date;


@AllArgsConstructor
@Data
@Table
@Getter
@Setter

public class Reminder {

    @Id
    private String reminder_id;
    private Date date;
    private Time time;
    private String venue;
    private String lec_id;
    private String exam_id ;





}