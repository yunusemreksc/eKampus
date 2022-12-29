package com.EKampus.controller;

import com.EKampus.DTO.FacultyDto;
import com.EKampus.model.Faculty;
import com.EKampus.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getAllFaculty(){
        return facultyService.getAllFaculty();
    }
    @GetMapping("/{facultyId}")
    public Faculty getFaculty(@PathVariable Long facultyId){
        return facultyService.getFacultyById(facultyId);
    }

    @PostMapping()
    public FacultyDto addFaculty(@RequestBody Faculty faculty)
    {
        return facultyService.addFaculty(faculty);
    }

    @PutMapping("/{facultyId}/departments/{departmentId}")
    public Faculty departmentAddToStudent(@PathVariable Long departmentId, @PathVariable Long facultyId){
        return facultyService.departmentAddToFacultyService(facultyId,departmentId);
    }

    @DeleteMapping("/{facultyId}/departments/{departmentId}")
    public Faculty departmentRemoveFromStudent(@PathVariable Long departmentId, @PathVariable Long facultyId){
        return facultyService.departmentRemoveFromFacultyService(facultyId,departmentId);
    }

    @DeleteMapping("/{facultyId}")
    public FacultyDto removeFaculty(@PathVariable Long facultyId){
        return facultyService.removeFaculty(facultyId);
    }


}
