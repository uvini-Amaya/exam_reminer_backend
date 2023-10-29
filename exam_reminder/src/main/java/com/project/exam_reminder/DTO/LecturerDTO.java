package com.project.exam_reminder.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecturerDTO {

    private String lecId;
    private String lecName;
    private String lecEmail;
    private String lecContact ;
    private String lecPassword;


}
