package com.EKampus.service;

import com.EKampus.DTO.HrDto;
import com.EKampus.model.*;
import com.EKampus.repository.DepartmentRepo;
import com.EKampus.repository.HrRepo;
import com.EKampus.repository.StudentAffairsRepo;
import com.EKampus.repository.AdvisorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class HrService {

    private final HrRepo hrRepo;
    private final DepartmentRepo departmentRepo;
    private final AdvisorRepo advisorRepo;
    private final StudentAffairsRepo studentAffairsRepo;

    public HrService(HrRepo hrRepo, DepartmentRepo departmentRepo, AdvisorRepo advisorRepo, StudentAffairsRepo studentAffairsRepo) {
        this.hrRepo = hrRepo;
        this.departmentRepo = departmentRepo;
        this.advisorRepo = advisorRepo;
        this.studentAffairsRepo = studentAffairsRepo;
    }

    public List<Hr> getAllHr() {
        return hrRepo.findAll();
    }

    public Hr getHrById(Long id) {
        return hrRepo.findById(id).get();
    }

    public HrDto addHr(Hr hr) {
        Hr savedHr = hrRepo.save(hr);
        return new HrDto(
                savedHr.getBankNo()
        );
    }
    public Hr advisorAddToHr(Long advisorId, Long HrId) {
        Set<Advisor> setAdvisor =null;
        Hr hr = hrRepo.findById(HrId).get();
        Advisor advisor = advisorRepo.findById(advisorId).get();
        setAdvisor = hr.getAdvisorSet();
        setAdvisor.add(advisor);
        hr.setAdvisorSet(setAdvisor);
        return hrRepo.save(hr);
    }
    public Hr advisorRemoveFromHr(Long advisorId, Long HrId) {
        Set<Advisor> setAdvisor =null;
        Hr hr = hrRepo.findById(HrId).get();
        Advisor advisor = advisorRepo.findById(advisorId).get();
        setAdvisor = hr.getAdvisorSet();
        setAdvisor.remove(advisor);
        hr.setAdvisorSet(setAdvisor);
        return hrRepo.save(hr);
    }
    public Hr studentAffairsAddToHr(Long studentAffairsId, Long HrId) {
        Set<StudentAffairs> setStudentAffairs = null;
        Hr hr = hrRepo.findById(HrId).get();
        StudentAffairs studentAffairs= studentAffairsRepo.findById(studentAffairsId).get();
        setStudentAffairs= hr.getStudentAffairsSet();
        setStudentAffairs.add(studentAffairs);
        hr.setStudentAffairsSet(setStudentAffairs);
        return hrRepo.save(hr);
    }
    public Hr studentAffairsRemoveFromHr(Long studentAffairsId, Long HrId) {
        Set<StudentAffairs> setStudentAffairs = null;
        Hr hr = hrRepo.findById(HrId).get();
        StudentAffairs studentAffairs= studentAffairsRepo.findById(studentAffairsId).get();
        setStudentAffairs= hr.getStudentAffairsSet();
        setStudentAffairs.remove(studentAffairs);
        hr.setStudentAffairsSet(setStudentAffairs);
        return hrRepo.save(hr);
    }
}
