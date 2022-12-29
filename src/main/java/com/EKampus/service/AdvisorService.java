package com.EKampus.service;
import com.EKampus.model.*;
import com.EKampus.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.EKampus.model.Lesson;
import com.EKampus.model.Advisor;

import java.util.List;
import java.util.Set;

@Service
public class AdvisorService {

    @Autowired
    private final AdvisorRepo advisorRepo;
    @Autowired
    private final FacultyRepo facultyRepo;
    @Autowired
    private final DepartmentRepo departmentRepo;
    @Autowired
    private  final LessonRepo lessonRepo;

    public AdvisorService(AdvisorRepo advisorRepo, FacultyRepo facultyRepo, DepartmentRepo departmentRepo, LessonRepo lessonRepo) {
        this.advisorRepo = advisorRepo;
        this.facultyRepo = facultyRepo;
        this.departmentRepo = departmentRepo;
        this.lessonRepo = lessonRepo;
    }
    public Advisor addAdvisor(Advisor advisor) {
        this.advisorRepo.save(advisor);
        return advisor;
    }
    public List<Advisor> getAllAdvisor() {
        return advisorRepo.findAll();
    }
    public Advisor getAdvisorById(Long id) {
        return advisorRepo.findById(id).get();
    }
    public Advisor facultyAddToAdvisorService(Long advisorId, Long facultyId) {
        Set<Faculty> setFaculty=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Faculty faculty= facultyRepo.findById(facultyId).get();
        setFaculty= advisor.getFaculty();
        setFaculty.add(faculty);
        advisor.setFaculty(setFaculty);
        return advisorRepo.save(advisor);
    }
    public Advisor facultyRemoveFromAdvisorService(Long advisorId, Long facultyId) {
        Set<Faculty> setFaculty=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Faculty faculty= facultyRepo.findById(facultyId).get();
        setFaculty= advisor.getFaculty();
        setFaculty.remove(faculty);
        advisor.setFaculty(setFaculty);
        return advisorRepo.save(advisor);
    }

    public Advisor departmentAddToAdvisorService(Long advisorId, Long departmentId) {
        Set<Department> setDepartment=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment= advisor.getDepartments();
        setDepartment.add(department);
        advisor.setDepartments(setDepartment);
        return advisorRepo.save(advisor);
    }
    public Advisor departmentRemoveFromAdvisorService(Long advisorId, Long departmentId) {
        Set<Department> setDepartment=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Department department= departmentRepo.findById(departmentId).get();
        setDepartment= advisor.getDepartments();
        setDepartment.remove(department);
        advisor.setDepartments(setDepartment);
        return advisorRepo.save(advisor);
    }
    public Advisor lessonAddToAdvisorService(Long advisorId, Long lessonId) {
        Set<Lesson> setLesson=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson= advisor.getLessons();
        setLesson.add(lesson);
        advisor.setLessons(setLesson);
        return advisorRepo.save(advisor);
    }

    public Advisor lessonRemoveFromAdvisorService(Long advisorId, Long lessonId) {
        Set<Lesson> setLesson=null;
        Advisor advisor = advisorRepo.findById(advisorId).get();
        Lesson lesson= lessonRepo.findById(lessonId).get();
        setLesson= advisor.getLessons();
        setLesson.remove(lesson);
        advisor.setLessons(setLesson);
        return advisorRepo.save(advisor);
    }
}
