package com.casemodule4.controller;

import com.casemodule4.model.AppUser;
import com.casemodule4.model.Diary;
import com.casemodule4.service.AppUserService;
import com.casemodule4.service.IAppUserService;
import com.casemodule4.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.aspectj.bridge.Version.getTime;


@RestController
@CrossOrigin("*")
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    IDiaryService diaryService;

    @Autowired
    IAppUserService appUserService;


    @GetMapping("/diary")
    public ResponseEntity<List<Diary>> findALlDiary(){
        return  new ResponseEntity(diaryService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/diary/{id}")
    public ResponseEntity<Diary> addDiary(@RequestBody Diary diary,@PathVariable int id){
        Optional<AppUser> appUser = appUserService.getAppUserById(id);
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diary.setLectureName(appUser.get().getName());
        diaryService.save(diary);
        return new ResponseEntity(diary,HttpStatus.OK);
    }

    @GetMapping("/diary/{id}")
    public ResponseEntity<Diary> showUpdateForm(@PathVariable int id){
        return  new ResponseEntity(diaryService.findById(id),HttpStatus.OK);
    }

    @PutMapping("/diary/{id}")
    public ResponseEntity<Diary> updateDiary(@RequestBody Diary diary,@PathVariable int id){
        Optional<AppUser> appUser = appUserService.getAppUserById(id);
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diary.setLectureName(appUser.get().getName());
        diaryService.save(diary);
        return new ResponseEntity(diary,HttpStatus.OK);
    }

    @DeleteMapping("/diary/{id}")
    public ResponseEntity deleteDiary(@PathVariable int id){
        diaryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
