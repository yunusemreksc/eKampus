package com.EKampus.service;

import com.EKampus.DTO.FacultyDto;
import com.EKampus.model.Department;
import com.EKampus.model.Faculty;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FacultyService {

    private final FacultyRepo facultyRepo;
    private final DepartmentRepo departmentRepo;


    public FacultyService(FacultyRepo facultyRepo, DepartmentRepo departmentRepo) {
        this.facultyRepo = facultyRepo;
        this.departmentRepo = departmentRepo;
    }

    public FacultyDto addFaculty(Faculty faculty) {
        Faculty savedFaculty = facultyRepo.save(faculty);
        return new FacultyDto(
                savedFaculty.getFacultyName(),
                savedFaculty.getFacultyAdminName()
        );
    }

    public FacultyDto removeFaculty(Long facultyId) {
        Faculty savedFaculty= facultyRepo.findById(facultyId).get();
        facultyRepo.delete(savedFaculty);
        return new FacultyDto(
                savedFaculty.getFacultyName(),
                savedFaculty.getFacultyAdminName()
        );
    }

    public Faculty departmentAddToFacultyService(Long departmentId, Long facultyId) {
        Set<Department> setDepartment=null;
        Faculty faculty= facultyRepo.findById(facultyId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=faculty.getDepartments();
        setDepartment.add(department);
        faculty.setDepartments(setDepartment);
        return facultyRepo.save(faculty);
    }

    public Faculty departmentRemoveFromFacultyService(Long departmentId, Long facultyId) {
        Set<Department> setDepartment=null;
        Faculty faculty= facultyRepo.findById(facultyId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=faculty.getDepartments();
        setDepartment.remove(department);
        faculty.setDepartments(setDepartment);
        return facultyRepo.save(faculty);
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepo.findById(id).get();
    }

}
