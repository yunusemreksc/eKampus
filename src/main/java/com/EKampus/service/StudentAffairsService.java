package com.EKampus.service;

import com.EKampus.model.Department;
import com.EKampus.model.Faculty;
import com.EKampus.model.StudentAffairs;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.FacultyRepo;
import com.EKampus.repository.StudentAffairsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StudentAffairsService {

    @Autowired
    private final StudentAffairsRepo studentAffairsRepo;

    @Autowired
    private final DepartmentRepo departmentRepo;

    @Autowired
    private final FacultyRepo facultyRepo;

    public StudentAffairsService(StudentAffairsRepo studentAffairsRepo, DepartmentRepo departmentRepo, FacultyRepo facultyRepo) {
        this.studentAffairsRepo = studentAffairsRepo;
        this.departmentRepo = departmentRepo;
        this.facultyRepo = facultyRepo;
    }

    public List<StudentAffairs> getAllStudentAffairs() {
        return studentAffairsRepo.findAll();
    }

    public StudentAffairs getStudentAffairsById(Long id) {
        return studentAffairsRepo.findById(id).get();
    }


    public StudentAffairs addStudentAffairs(StudentAffairs studentAffairs) {
        this.studentAffairsRepo.save(studentAffairs);
        return studentAffairs;
    }

    public StudentAffairs facultyAddToStudentAffairs(Long studentAffairsId, Long facultyId) {
        StudentAffairs studentAffairs= studentAffairsRepo.findById(studentAffairsId).get();
        Faculty faculty= facultyRepo.findById(facultyId).get();
        studentAffairs.setFaculty(faculty);
        return studentAffairsRepo.save(studentAffairs);
    }

    public StudentAffairs departmentAddToStudentAffairsService(Long studentAffairsId, Long departmentId) {
        Set<Department> setDepartment=null;
        StudentAffairs studentAffairs= studentAffairsRepo.findById(studentAffairsId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=studentAffairs.getDepartments();
        setDepartment.add(department);
        studentAffairs.setDepartments(setDepartment);
        return studentAffairsRepo.save(studentAffairs);
    }

    public StudentAffairs departmentRemoveFromStudentAffairsService(Long studentAffairsId, Long departmentId) {
        Set<Department> setDepartment=null;
        StudentAffairs studentAffairs= studentAffairsRepo.findById(studentAffairsId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment=studentAffairs.getDepartments();
        setDepartment.remove(department);
        studentAffairs.setDepartments(setDepartment);
        return studentAffairsRepo.save(studentAffairs);
    }
}
