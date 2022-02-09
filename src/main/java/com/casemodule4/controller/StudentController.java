package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.model.Grades;
import com.casemodule4.model.Subject;
import com.casemodule4.service.IAppUserService;
import com.casemodule4.service.IFeeService;
import com.casemodule4.service.IGradesService;
import com.casemodule4.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IFeeService feeService;

    @Autowired
    ISubjectService subjectService;

    @Autowired
    IAppUserService appUserService;

    @Autowired
    IGradesService gradesService;

    @GetMapping("/{id}/fee")
    public ResponseEntity findAllFee(@PathVariable int id) {
        return new ResponseEntity(appUserService.getAppUserById(id).get().getFee(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public AppUser showAppUsers(@PathVariable int id) {
        return appUserService.getAppUserById(id).get();
    }

    @PostMapping("/grades/{id}")
    public ResponseEntity<Subject> create(@PathVariable int id, @RequestBody Grades grades) {
        Subject subject = subjectService.findById(id).get();
        subject.getGrades().add(grades);
        gradesService.save(grades);
        subjectService.save(subject);
        return new ResponseEntity<>(subject, HttpStatus.OK);
    }

    @GetMapping("/{id}/subjects")
    public ResponseEntity<Subject> findAllGrades(@PathVariable int id) {
        return new ResponseEntity(subjectService.findAllByUserId(id), HttpStatus.OK);
    }

    @GetMapping("/grades/{id}")
    public ResponseEntity<Grades> getGrade(@PathVariable int id) {
        return new ResponseEntity(gradesService.findById(id), HttpStatus.OK);
    }
}
