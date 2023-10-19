package com.project.exam_reminder.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Admin {
    @Id
    private String ad_id;
    private String ad_name;
    private String ad_email;
    private String lec_contact ;
}
