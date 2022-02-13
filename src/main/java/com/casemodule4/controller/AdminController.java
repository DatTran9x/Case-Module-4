package com.casemodule4.controller;

import com.casemodule4.model.Subject;
import com.casemodule4.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ISubjectService iSubjectService;

    @GetMapping("/showSubject")
    public List<Subject> showListSubject() {
        return iSubjectService.findAll();
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        iSubjectService.save(subject);
        return subject;
    }
}
