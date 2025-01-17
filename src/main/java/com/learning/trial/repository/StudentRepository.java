package com.learning.trial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.trial.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByCollegeNameOrderByNameDesc(String collegeName);

}
