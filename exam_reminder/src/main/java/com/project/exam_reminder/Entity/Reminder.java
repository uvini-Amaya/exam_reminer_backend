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

    public String getReminder_id() {
        return reminder_id;
    }

    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getVenue() {
        return venue;
    }

    public String getLec_id() {
        return lec_id;
    }

    public String getExam_id() {
        return exam_id;
    }

    public void setReminder_id(String reminder_id) {
        this.reminder_id = reminder_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public void setExam_id(String exam_id) {
        this.exam_id = exam_id;
    }



}