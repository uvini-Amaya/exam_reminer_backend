package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;

import java.sql.Time;
import java.util.Date;

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

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public void setStu_mobile(String stu_mobile) {
        this.stu_mobile = stu_mobile;
    }

    public String getStu_name() {
        return stu_name;
    }

    public String getStu_address() {
        return stu_address;
    }

    public String getStu_mobile() {
        return stu_mobile;
    }

    private String stu_mobile;


}