package com.project.exam_reminder.Controller;

import com.project.exam_reminder.DTO.ReminderDTO;
import com.project.exam_reminder.Service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping({"api/examreminder/reminder"})
@CrossOrigin
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @PostMapping({"/addreminder"})
    public ResponseEntity addAllReminders(@RequestBody ReminderDTO reminderDTO){
        Map<String,Object> map= new LinkedHashMap<>();
        ReminderDTO res = ReminderService.addReminder(reminderDTO);
        if (res != null){
            map.put("status",1);
            map.put("message","success");
            map.put("data",res);
        }
        else {
            map.put("status", 0);
            map.put("message", "Event not added");
        }
        return new ResponseEntity(map, HttpStatus.OK);

    }

}
