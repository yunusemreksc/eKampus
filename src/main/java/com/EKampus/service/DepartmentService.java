package com.EKampus.service;

import com.EKampus.DTO.DepartmentDto;
import com.EKampus.model.Department;
import com.EKampus.model.Lesson;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.FacultyRepo;
import com.EKampus.repository.LessonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final FacultyRepo facultyRepo;
    @Autowired
    private final LessonRepo lessonRepo;

    public DepartmentService(DepartmentRepo departmentRepo, FacultyRepo facultyRepo, LessonRepo lessonRepo) {
        this.departmentRepo = departmentRepo;
        this.facultyRepo = facultyRepo;
        this.lessonRepo = lessonRepo;
    }


    public DepartmentDto addDepartment(Department department) {
        Department savedDepartment = departmentRepo.save(department);
        return new DepartmentDto(
                savedDepartment.getDepartmentName(),
                savedDepartment.isInstituteOrFaculty()
        );
    }

    public DepartmentDto removeDepartment(Long departmentId) {
        Department savedDepartment= departmentRepo.findById(departmentId).get();
        departmentRepo.delete(savedDepartment);
        return new DepartmentDto(
                savedDepartment.getDepartmentName(),
                savedDepartment.isInstituteOrFaculty()
        );
    }

    public List<Department> getAllDepartment() {
        return departmentRepo.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepo.findById(id).get();
    }


    public Department lessonAddToDepartmentService(Long lessonId, Long departmentId) {
        Set<Lesson> setLesson=null;
        Department department= departmentRepo.findById(departmentId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson=department.getLessons();
        setLesson.add(lesson);
        department.setLessons(setLesson);
        return departmentRepo.save(department);
    }


    public Department lessonRemoveFromDepartmentService(Long lessonId, Long departmentId) {
        Set<Lesson> setLesson=null;
        Department department= departmentRepo.findById(departmentId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson=department.getLessons();
        setLesson.remove(lesson);
        department.setLessons(setLesson);
        return departmentRepo.save(department);
    }






}
