package com.EKampus.controller;

import com.EKampus.DTO.HrDto;
import com.EKampus.model.Hr;
import com.EKampus.service.HrService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr")
@RequiredArgsConstructor
public class HrController {

    private final HrService hrService;


    @GetMapping()
    public List<Hr> getAllHr(){
        return hrService.getAllHr();
    }

    @GetMapping("/{hrId}")
    public Hr getHr(@PathVariable Long HrId, @PathVariable String hrId){
        return hrService.getHrById(HrId);
    }

    @PostMapping()
    public HrDto addHr(@RequestBody Hr hr)
    {
        return hrService.addHr(hr);
    }

    @PutMapping("/{hrId}/advisor/{advisorId}")
    public Hr advisorAddToHr(@PathVariable Long HrId, @PathVariable Long advisorId, @PathVariable String hrId){
        return hrService.advisorAddToHr(advisorId,HrId);
    }

    @DeleteMapping("/{HrId}/advisor/{advisorId}")
    public Hr advisorRemoveFromHr(@PathVariable Long HrId, @PathVariable Long advisorId){
        return hrService.advisorRemoveFromHr(advisorId, HrId);
    }

    @PutMapping("/{HrId}/studentAffairs/{studentAffairsId}")
    public Hr studentAffairsAddToHr(@PathVariable Long HrId, @PathVariable Long studentAffairsId){
        return hrService.studentAffairsAddToHr(studentAffairsId, HrId);
    }

    @DeleteMapping("/{HrId}/studentAffairs/{studentAffairsId}")
    public Hr studentAffairsRemoveFromHr(@PathVariable Long HrId, @PathVariable Long studentAffairsId){
        return hrService.studentAffairsRemoveFromHr(studentAffairsId, HrId);
    }
}
