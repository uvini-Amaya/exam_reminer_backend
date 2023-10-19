package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Lecturer {
    

        @Id
        private String lec_id;
        private String lec_name;
        private String lec_email;
        private String lec_contact ;


//        @Override
//        public String toString() {
//            return "Lecturer{" +
//                    "Lecturer_id='" + lec_id + '\'' +
//                    ", lecturer_name='" + lec_name + '\'' +
//                    ", Lecturer_email='" + lec_email + '\'' +
//                    ", Lecturer_contact='" + lec_contact + '\'' +
//                    '}';
//        }

}
