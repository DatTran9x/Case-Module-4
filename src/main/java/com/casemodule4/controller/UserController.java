package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.service.IAppUserService;
import com.casemodule4.service.IRoleService;
import org.apache.catalina.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class UserController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IAppUserService appUserService;

    @Autowired
    IRoleService roleService;

    @GetMapping()
    public ResponseEntity<List<AppUser>> listUsers() {
        return  new ResponseEntity(appUserService.getAppUserList(), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Role>> listRoles() {
        return  new ResponseEntity(roleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUser(@PathVariable int id){
        return  new ResponseEntity(appUserService.getAppUserById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppUser> addAppUser(AppUser appUser){
//        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUserService.addAppUser(appUser);
        return new ResponseEntity(appUser,HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<AppUser> updateAppUser(AppUser appUser){
        appUserService.addAppUser(appUser);
        return new ResponseEntity(appUser,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAppUser(@PathVariable int id){
        appUserService.deleteAppUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<AppUser>> search(@PathVariable String name){
       return  new ResponseEntity(appUserService.findAppUserByName(name),HttpStatus.OK);
    }
}
