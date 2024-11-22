package com.learning.trial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.trial.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
