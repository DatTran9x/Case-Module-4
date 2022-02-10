package com.casemodule4.controller;

import com.casemodule4.model.AppUserStatus;
import com.casemodule4.service.IAppUserStatusService;
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
@RequestMapping("/status")
public class StatusController {
    @Autowired
    IAppUserStatusService appUserStatusService;
    @GetMapping()
    public ResponseEntity<List<AppUserStatus>> getAllStatus(){
        return new ResponseEntity<>(appUserStatusService.findAll(), HttpStatus.OK);
    }

}
