package com.EKampus.repository;

import com.EKampus.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AdminRepo extends JpaRepository<Admin, Long> {
}
