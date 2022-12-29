package com.EKampus.controller;

import com.EKampus.model.Advisor;
import com.EKampus.service.AdvisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/advisors")
@RequiredArgsConstructor
public class AdvisorController {
    private final AdvisorService advisorService;

    @PostMapping()
    public Advisor addAdvisor(@RequestBody Advisor advisor)
    {
        return advisorService.addAdvisor(advisor);
    }
    @GetMapping()
    public List<Advisor> getAllAdvisor(){
        return advisorService.getAllAdvisor();
    }
    @GetMapping("/{advisorId}")
    public Advisor getAdvisor(@PathVariable Long advisorId){
        return advisorService.getAdvisorById(advisorId);
    }
    @PutMapping("/{advisorId}/faculties/{facultyId}")
    public Advisor facultyAddToAdvisor(@PathVariable Long advisorId, @PathVariable Long facultyId){
        return advisorService.facultyAddToAdvisorService(advisorId,facultyId);
    }
    @PutMapping("/{advisorId}/departments/{departmentId}")
    public Advisor departmentAddToAdvisor(@PathVariable Long advisorId, @PathVariable Long departmentId){
        return advisorService.departmentAddToAdvisorService(advisorId,departmentId);
    }
    @PutMapping("/{advisorId}/lessons/{lessonId}")
    public Advisor lessonAddToAdvisor(@PathVariable Long advisorId, @PathVariable Long lessonId){
        return advisorService.lessonAddToAdvisorService(advisorId,lessonId);
    }
    @DeleteMapping("/{advisorId}/faculties/{facultyId}")
    public Advisor facultyRemoveFromAdvisor(@PathVariable Long advisorId, @PathVariable Long facultyId){
        return advisorService.facultyRemoveFromAdvisorService(advisorId,facultyId);
    }
    @DeleteMapping("/{advisorId}/departments/{departmentId}")
    public Advisor departmentRemoveFromAdvisor(@PathVariable Long advisorId, @PathVariable Long departmentId){
        return advisorService.departmentRemoveFromAdvisorService(advisorId,departmentId);
    }
    @DeleteMapping("/{advisorId}/lessons/{lessonId}")
    public Advisor lessonRemoveFromAdvisor(@PathVariable Long advisorId, @PathVariable Long lessonId){
        return advisorService.lessonRemoveFromAdvisorService(advisorId,lessonId);
    }

}
