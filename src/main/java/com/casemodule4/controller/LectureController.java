package com.casemodule4.controller;

import com.casemodule4.model.*;
import com.casemodule4.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

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

    @Autowired
    ISubjectService studentsService;

    @Autowired
    ICheckService checkService;


    @GetMapping("{classroomId}/diary/")
    public ResponseEntity<Set<Diary>> findALlDiaryForClassroom(@PathVariable int classroomId) {
        Set<Diary> list = classService.findById(classroomId).get().getDiary();
        return new ResponseEntity(list, HttpStatus.OK);
    }


    @GetMapping("/diary/{id}")
    public ResponseEntity<Diary> showUpdateForm(@PathVariable int id) {
        return new ResponseEntity(diaryService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/student/diary/{studentId}")
    public ResponseEntity<Set<Diary>> findAllForStudent(@PathVariable int studentId){
        Set<Diary> list = appUserService.getAppUserById(studentId).get().getDiary();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/diary/{classroomId}")
    public ResponseEntity<Diary> addDiaryForClassroom(@RequestBody Diary diary, @PathVariable int classroomId) {
        Classroom classroom = classService.findById(classroomId).get();
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diaryService.save(diary);
        classroom.getDiary().add(diary);
        classService.save(classroom);
        return new ResponseEntity(diary, HttpStatus.OK);
    }


    @PostMapping("{studentId}/diary/")
    public ResponseEntity<Diary> addDiaryForStudent(@RequestBody Diary diary, @PathVariable int studentId) {
        AppUser student = appUserService.getAppUserById(studentId).get();
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diaryService.save(diary);
        student.getDiary().add(diary);
        appUserService.addAppUser(student);
        return new ResponseEntity(diary, HttpStatus.OK);
    }

    @PutMapping("/diary/{studentId}")
    public ResponseEntity<Diary> updateDiary(@RequestBody Diary diary,@PathVariable int studentId) {
        AppUser student = appUserService.getAppUserById(studentId).get();
        diary.setDateOfWrite(new Date(System.currentTimeMillis()));
        diary.setLectureName(student.getName());
        diaryService.save(diary);
        return new ResponseEntity(diary, HttpStatus.OK);
    }

    @DeleteMapping("/{classroomId}/diary/{id}")
    public ResponseEntity deleteDiaryForClassroom(@PathVariable int id,@PathVariable int classroomId) {
        Classroom classroom =   classService.findById(classroomId).get();
        classroom.getDiary().remove(diaryService.findById(id).get());
        diaryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/diary/{studentId}/{id}")
    public ResponseEntity deleteDiaryForStudent(@PathVariable int id,@PathVariable int studentId) {
        AppUser student = appUserService.getAppUserById(studentId).get();
        student.getDiary().remove(diaryService.findById(id).get());
        System.out.println(student.getDiary());
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

    @GetMapping("/check")
    public ResponseEntity<List<RollCall>> findAllCheck(){
        return new ResponseEntity(checkService.findAll(),HttpStatus.OK);
    }

    @PostMapping("{id}/check")
    public ResponseEntity<RollCall> createCheck(@PathVariable int id){
        RollCall rollCall = new RollCall();
        rollCall.setDate(new Date(System.currentTimeMillis()));
        rollCall.setChecked(true);
        AppUser appUser = appUserService.getAppUserById(id).get();
        appUser.getRollCall().add(rollCall);
        checkService.save(rollCall);
        return new ResponseEntity(rollCall,HttpStatus.OK);
    }

//    @PutMapping("/check")
//    public ResponseEntity<Check> updateCheck(){
//        checkService.save(check);
//        return new ResponseEntity(check,HttpStatus.OK);
//    }

    @DeleteMapping("/check/{id}")
    public ResponseEntity deleteCheck(@PathVariable  int id){
        checkService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("{id}/check/exist")
    public Boolean getCheck(@PathVariable int id){
        AppUser appUser = appUserService.getAppUserById(id).get();
        return checkService.checkIfChecked(appUser);
    }
}
