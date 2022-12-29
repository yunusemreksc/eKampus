package com.EKampus.service;

import com.EKampus.DTO.InstituteDto;
import com.EKampus.model.Department;
import com.EKampus.model.Institute;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.InstituteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class InstituteService {
    private final InstituteRepo instituteRepo;
    private final DepartmentRepo departmentRepo;

    public InstituteService(InstituteRepo instituteRepo, DepartmentRepo departmentRepo) {
        this.instituteRepo = instituteRepo;
        this.departmentRepo = departmentRepo;
    }

    public InstituteDto addInstitute(Institute institute) {
        Institute savedInstitute = instituteRepo.save(institute);
        return new InstituteDto(
                savedInstitute.getInstituteName(),
                savedInstitute.getInstituteAdminName()
        );
    }

    public InstituteDto removeInstitute(Long instituteId) {
        Institute savedInstitute= instituteRepo.findById(instituteId).get();
        instituteRepo.delete(savedInstitute);
        return new InstituteDto(
                savedInstitute.getInstituteName(),
                savedInstitute.getInstituteAdminName()
        );
    }

    public Institute departmentAddToInstituteService(Long departmentId, Long instituteId) {
        Set<Department> setDepartment=null;
        Institute institute= instituteRepo.findById(instituteId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=institute.getDepartments();
        setDepartment.add(department);
        institute.setDepartments(setDepartment);
        return instituteRepo.save(institute);
    }

    public Institute departmentRemoveFromInstituteService(Long departmentId, Long instituteId) {
        Set<Department> setDepartment=null;
        Institute institute= instituteRepo.findById(instituteId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=institute.getDepartments();
        setDepartment.remove(department);
        institute.setDepartments(setDepartment);
        return instituteRepo.save(institute);
    }

    public List<Institute> getAllInstitutes() {
        return instituteRepo.findAll();
    }

    public Institute getInstituteById(Long id) {
        return instituteRepo.findById(id).get();
    }

}
