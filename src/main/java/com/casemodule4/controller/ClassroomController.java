package com.casemodule4.controller;

import com.casemodule4.model.Classroom;
import com.casemodule4.model.Role;
import com.casemodule4.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    IClassService classService;

    @GetMapping
    public ResponseEntity<List<Classroom>> getAllRole(){
        return new ResponseEntity<>(classService.findAll(), HttpStatus.OK);
    }
}
