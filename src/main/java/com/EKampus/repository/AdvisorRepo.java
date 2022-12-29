package com.EKampus.repository;

import com.EKampus.model.Advisor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepo extends JpaRepository<Advisor, Long> {
}
