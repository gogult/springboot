package com.learning.trial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.trial.Model.College;
import com.learning.trial.Model.Student;
import com.learning.trial.service.CollegeService;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping("")
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.createCollege(college));

    }

    @PostMapping("/{collegeId}/students")
    public ResponseEntity<Student> createStudent(@PathVariable Long collegeId, @RequestBody Student student) {
        // System.out.println(collegeService.createStudent(collegeId,student));
        //return collegeService.createStudent(collegeId, student);

        return ResponseEntity.status(HttpStatus.CREATED).body(collegeService.createStudent(collegeId, student));
    }

    @GetMapping("")
    public ResponseEntity<List<College>> getAllColleges() {
        return ResponseEntity.status(HttpStatus.OK).body(collegeService.getAllColleges());

    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentsByCollegeName(@RequestParam String collegeName) {
        return ResponseEntity.status(HttpStatus.OK).body(collegeService.getStudentsByCollegeName(collegeName));

    }
}
