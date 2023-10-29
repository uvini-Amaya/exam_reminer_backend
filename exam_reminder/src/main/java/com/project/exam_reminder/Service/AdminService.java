package com.project.exam_reminder.Service;
import com.project.exam_reminder.Controller.AdminController;
import com.project.exam_reminder.Repo.AdminRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;
}
