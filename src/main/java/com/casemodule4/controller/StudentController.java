package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/student")
public class StudentController {
    @Autowired
    AppUserService appUserService;

    @GetMapping("/{id}")
    public AppUser showAppUsers(@PathVariable int id) {
       return appUserService.getAppUserById(id).get();
    }
}


