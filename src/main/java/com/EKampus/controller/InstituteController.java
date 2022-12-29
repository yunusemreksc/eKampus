package com.EKampus.controller;

import com.EKampus.DTO.InstituteDto;
import com.EKampus.model.Institute;
import com.EKampus.service.InstituteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instituties")
@RequiredArgsConstructor
public class InstituteController {
    private final InstituteService instituteService;

    @GetMapping()
    public List<Institute> getAllInstitutes(){
        return instituteService.getAllInstitutes();
    }
    @GetMapping("/{instituteId}")
    public Institute getInstituteById(@PathVariable Long instituteId){return instituteService.getInstituteById(instituteId);}

    @PostMapping()
    public InstituteDto addInstitute(@RequestBody Institute institute)
    {
        return instituteService.addInstitute(institute);
    }

    @PutMapping("/{instituteID}/departments/{departmentId}")
    public Institute departmentAddToInstitute(@PathVariable Long departmentId, @PathVariable Long instituteID){
        return instituteService.departmentAddToInstituteService(instituteID,departmentId);
    }

    @DeleteMapping("/{instituteId}/departments/{departmentId}")
    public Institute departmentRemoveFromInstitute(@PathVariable Long departmentId, @PathVariable Long instituteId){
        return instituteService.departmentRemoveFromInstituteService(instituteId,departmentId);
    }

    @DeleteMapping("/{instituteId}")
    public InstituteDto instituteRemove(@PathVariable Long instituteId){
        return instituteService.removeInstitute(instituteId);
    }
}
