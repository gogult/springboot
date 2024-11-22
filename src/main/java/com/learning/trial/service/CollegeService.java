package com.learning.trial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.learning.trial.Model.College;
import com.learning.trial.Model.Student;
import com.learning.trial.repository.CollegeRepository;
import com.learning.trial.repository.StudentRepository;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    public Student createStudent(Long collegeId, Student student) {
        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new IllegalArgumentException("College not found"));
        student.setCollege(college);
        college.addStudent(student);
        return studentRepository.save(student);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    public List<Student> getStudentsByCollegeName(String collegeName) {
        return studentRepository.findByCollegeNameOrderByNameDesc(collegeName);
    }
}
