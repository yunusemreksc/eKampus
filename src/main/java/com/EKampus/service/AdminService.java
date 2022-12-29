package com.EKampus.service;

import com.EKampus.model.Admin;
import com.EKampus.repository.*;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final DepartmentRepo departmentRepo;
    private final FacultyRepo facultyRepo;
    private final AdminRepo adminRepo;


    public AdminService (DepartmentRepo departmentRepo, FacultyRepo facultyRepo, AdminRepo adminRepo)
    {
        this.departmentRepo = departmentRepo;
        this.facultyRepo = facultyRepo;
        this.adminRepo = adminRepo;
    }

    public Admin getAdminById(Long adminId){return adminRepo.findById(adminId).get();}

}
