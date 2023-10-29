package com.project.exam_reminder.Controller;

import com.project.exam_reminder.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"api/examreminder/admin"})
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;
}
