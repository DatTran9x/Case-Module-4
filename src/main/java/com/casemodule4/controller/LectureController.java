package com.casemodule4.controller;

import com.casemodule4.model.*;
import com.casemodule4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    IDiaryService diaryService;

    @Autowired
    IAppUserService appUserService;

    @Autowired
    IClassService classService;

    @Autowired
    IFeeService feeService;

    @Autowired
    ISubjectService subjectService;

    @Autowired
    IGradesService gradesService;


    @GetMapping("/diary")
    public ResponseEntity<List<Diary>> findALlDiary() {
        return new ResponseEntity(diaryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/diary/{classroomId}")
    public ResponseEntity<Diary> addDiary(@RequestBody Diary diary, @PathVariable int classroomId) {
        Classroom classroom = classService.findById(classroomId).get();
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diaryService.save(diary);
        classroom.getDiary().add(diary);
        classService.save(classroom);
        return new ResponseEntity(diary, HttpStatus.OK);
    }

    @GetMapping("/diary/{id}")
    public ResponseEntity<Diary> showUpdateForm(@PathVariable int id) {
        return new ResponseEntity(diaryService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/diary/")
    public ResponseEntity<Diary> updateDiary(@RequestBody Diary diary) {
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diaryService.save(diary);
        return new ResponseEntity(diary, HttpStatus.OK);
    }

    @DeleteMapping("/{classroomId}/diary/{id}")
    public ResponseEntity deleteDiary(@PathVariable int id,@PathVariable int classroomId) {
        Classroom classroom =   classService.findById(classroomId).get();
        classroom.getDiary().remove(diaryService.findById(id));
        diaryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/fee/{id}")
    public ResponseEntity deleteFee(@PathVariable int id) {
        feeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/fee")
    public ResponseEntity<Fee> addFee(@RequestBody Fee fee) {
        fee.setPayed(false);
        feeService.save(fee);
        return new ResponseEntity(fee, HttpStatus.OK);
    }

    @PutMapping("/fee")
    public ResponseEntity<Fee> updateFee(@RequestBody Fee fee) {
        feeService.save(fee);
        return new ResponseEntity(fee,HttpStatus.OK);
    }

    @GetMapping("/fee/{id}")
    public ResponseEntity<Fee> getFee(@PathVariable int id){
        return new ResponseEntity(feeService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/subjects/list")
    public ResponseEntity<List<Subject>> getListSubjects(){
        return new ResponseEntity(subjectService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/grades")
    public ResponseEntity<Grades> updateSubject(@RequestBody Grades grades){
        gradesService.save(grades);
        return new ResponseEntity(grades,HttpStatus.OK);
    }
}
