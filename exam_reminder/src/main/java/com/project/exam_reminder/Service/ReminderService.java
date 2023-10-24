package com.project.exam_reminder.Service;

import com.project.exam_reminder.DTO.ReminderDTO;
import com.project.exam_reminder.Repo.ReminderRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepo reminderRepo;

    @Autowired
    private ModelMapper modelMapper;
    public static ReminderDTO addReminder(ReminderDTO reminderDTO) {

    }
}
