package com.EKampus.repository;

import com.EKampus.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty, Long> {
}
