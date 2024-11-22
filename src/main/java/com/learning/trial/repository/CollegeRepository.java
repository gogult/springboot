package com.learning.trial.repository;

import com.learning.trial.Model.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
    College findByName(String name);
}
