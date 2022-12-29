package com.EKampus.repository;

import com.EKampus.model.StudentAffairs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAffairsRepo extends JpaRepository<StudentAffairs, Long> {
}
