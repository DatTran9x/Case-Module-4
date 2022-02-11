package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAppUserService appUserService;
@PostMapping("/create")
    public ResponseEntity createAppUser(@RequestBody AppUser appUser){
        appUserService.save(appUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
