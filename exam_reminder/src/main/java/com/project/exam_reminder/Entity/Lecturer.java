package com.project.exam_reminder.Entity;

import java.sql.Time;
import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@Data
@Table
public class Lecturer {




        @Id
        private String lec_id;
        private String lec_name;
        private String lec_email;
        private String lec_contact ;

        public Lecturer() {
        }

        @Override
        public String toString() {
            return "Lecturer{" +
                    "Lecturer_id='" + lec_id + '\'' +
                    ", lecturer_name='" + lec_name + '\'' +
                    ", Lecturer_email='" + lec_email + '\'' +
                    ", Lecturer_contact='" + lec_contact + '\'' +
                    '}';
        }

    public String getLec_id() {
        return lec_id;
    }

    public void setLec_id(String lec_id) {
        this.lec_id = lec_id;
    }

    public String getLec_name() {
        return lec_name;
    }

    public void setLec_name(String lec_name) {
        this.lec_name = lec_name;
    }

    public String getLec_email() {
        return lec_email;
    }

    public void setLec_email(String lec_email) {
        this.lec_email = lec_email;
    }

    public String getLec_contact() {
        return lec_contact;
    }

    public void setLec_contact(String lec_contact) {
        this.lec_contact = lec_contact;
    }
}
