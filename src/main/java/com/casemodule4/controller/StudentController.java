package com.casemodule4.controller;

import com.casemodule4.service.IFeeService;
import com.casemodule4.service.IGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
public class StudentController {
    @Autowired
    IFeeService feeService;

    @Autowired
    IGradesService gradesService;

    @GetMapping("/fee")
    public ResponseEntity findAllFee(){
        return  new ResponseEntity(feeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/grades")
    public ResponseEntity findAllGrades(){
        return new ResponseEntity(gradesService.findAll(), HttpStatus.OK);
    }
}
