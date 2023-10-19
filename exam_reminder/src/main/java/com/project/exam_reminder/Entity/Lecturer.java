package com.project.exam_reminder.Entity;



import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




@AllArgsConstructor
@Data
@Table
@Getter
@Setter
public class Lecturer {

        @Id
        private String lec_id;
        private String lec_name;
        private String lec_email;
        private String lec_contact ;
}
