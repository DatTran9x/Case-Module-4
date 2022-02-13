package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.model.Classroom;
import com.casemodule4.service.AppUserService;
import com.casemodule4.service.ClassroomService;
import com.casemodule4.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    AppUserService userService;
    @Autowired
    ClassroomService classroomService;

    @GetMapping
    public List<AppUser> showAppUsers() {
        return userService.getAppUserList();
    }

    @GetMapping("/showClass")
    public List<Classroom> showClassrooms() {
        return classroomService.findAll();
    }

    @GetMapping("/{id}")
    public List<AppUser> showAppUserByIdClassRoom(@PathVariable int id) {
        return userService.getAppUserByIdClassRoom(id);
    }

    
}
