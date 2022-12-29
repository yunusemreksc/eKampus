package com.EKampus.controller;

import com.EKampus.model.StudentAffairs;
import com.EKampus.service.StudentAffairsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentAffairs")
@RequiredArgsConstructor
public class StudentAffairsController {

    private final StudentAffairsService studentAffairsService;

    @GetMapping()
    public List<StudentAffairs> getAllStudent(){
        return studentAffairsService.getAllStudentAffairs();
    }

    @GetMapping("/{studentAffairsId}")
    public StudentAffairs getStudentAffairs(@PathVariable Long studentAffairsId){
        return studentAffairsService.getStudentAffairsById(studentAffairsId);
    }

    @PostMapping()
    public StudentAffairs addStudentAffairs(@RequestBody StudentAffairs studentAffairs)
    {
        return studentAffairsService.addStudentAffairs(studentAffairs);
    }

    @PutMapping("/{studentAffairsId}/faculty/{facultyId}")
    public StudentAffairs facultyAddForStudent(@PathVariable Long studentAffairsId,@PathVariable Long facultyId){
        return studentAffairsService.facultyAddToStudentAffairs(studentAffairsId,facultyId);
    }

    @PutMapping("/{studentAffairsId}/departments/{departmentId}")
    public StudentAffairs departmentAddForStudent(@PathVariable Long studentAffairsId,@PathVariable Long departmentId){
        return studentAffairsService.departmentAddToStudentAffairsService(studentAffairsId,departmentId);
    }

    @DeleteMapping("/{studentAffairsId}/departments/{departmentId}")
    public StudentAffairs departmentDeleteForStudentAffairs(@PathVariable Long studentAffairsId,@PathVariable Long departmentId){
        return studentAffairsService.departmentRemoveFromStudentAffairsService(studentAffairsId,departmentId);
    }


}
