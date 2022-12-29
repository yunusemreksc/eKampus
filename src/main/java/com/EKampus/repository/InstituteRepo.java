package com.EKampus.repository;

import com.EKampus.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepo extends JpaRepository<Institute,Long> {
}
