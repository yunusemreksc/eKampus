package com.EKampus.controller;

import com.EKampus.DTO.DepartmentDto;
import com.EKampus.model.Department;
import com.EKampus.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping()
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping()
    public DepartmentDto addDepartment(@RequestBody Department department)
    {
        return departmentService.addDepartment(department);
    }

    @DeleteMapping("/{departmentId}")
    public DepartmentDto removeDepartment(@PathVariable Long departmentId){
        return departmentService.removeDepartment(departmentId);
    }

    @PutMapping("/{departmentId}/lessons/{lessonId}")
    public Department lessonAddToDepartment(@PathVariable Long departmentId, @PathVariable Long lessonId){
        return departmentService.lessonAddToDepartmentService(departmentId,lessonId);
    }

    @DeleteMapping("/{departmentId}/lessons/{lessonId}")
    public Department lessonRemoveFromDepartment(@PathVariable Long departmentId, @PathVariable Long lessonId){
        return departmentService.lessonRemoveFromDepartmentService(departmentId,lessonId);
    }


}
