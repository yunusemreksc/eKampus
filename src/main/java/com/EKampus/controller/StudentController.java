package com.EKampus.controller;


import com.EKampus.DTO.StudentDto;
import com.EKampus.model.Student;
import com.EKampus.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping()
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping()
    public StudentDto addUser(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/{studentId}/faculties/{facultyId}")
    public Student facultyAddToStudent(@PathVariable Long studentId, @PathVariable Long facultyId){
        return studentService.facultyAddToStudentService(studentId,facultyId);
    }

    @PutMapping("/{studentId}/departments/{departmentId}")
    public Student departmentAddToStudent(@PathVariable Long studentId, @PathVariable Long departmentId){
        return studentService.departmentAddToStudentService(studentId,departmentId);
    }

    @PutMapping("/{studentId}/lessons/{lessonId}")
    public Student lessonAddToStudent(@PathVariable Long studentId, @PathVariable Long lessonId){
        return studentService.lessonAddToStudentService(studentId,lessonId);
    }

    @DeleteMapping("/{studentId}/faculties/{facultyId}")
    public Student facultyRemoveFromStudent(@PathVariable Long studentId, @PathVariable Long facultyId){
        return studentService.facultyRemoveFromStudentService(studentId,facultyId);
    }

    @DeleteMapping("/{studentId}/departments/{departmentId}")
    public Student departmentRemoveFromStudent(@PathVariable Long studentId, @PathVariable Long departmentId){
        return studentService.departmentRemoveFromStudentService(studentId,departmentId);
    }

    @DeleteMapping("/{studentId}/lessons/{lessonId}")
    public Student lessonRemoveFromStudent(@PathVariable Long studentId, @PathVariable Long lessonId){
        return studentService.lessonRemoveFromStudentService(studentId,lessonId);
    }
}
