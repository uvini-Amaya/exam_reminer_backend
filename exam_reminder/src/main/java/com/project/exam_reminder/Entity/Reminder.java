package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;


@AllArgsConstructor
@Data
@Table

public class Reminder {

    @Id
    private String reminder_id;

    private Date date;

    private Time time;

    private String venue;
    private String lec_id;
    private String exam_id ;

    public Reminder() {
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "reminder_id='" + reminder_id + '\'' +
                ", lecture_id='" + lec_id + '\'' +
                ", exam_id='" + exam_id + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", place='" + venue + '\'' +
                '}';
    }



}