package com.EKampus.controller;

import com.EKampus.DTO.LessonDto;
import com.EKampus.model.Lesson;
import com.EKampus.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;
    @GetMapping("/{lessonId}")
    public  Lesson getLesson(@PathVariable Long lessonId){
        return  lessonService.getLesson(lessonId);
    }
    @PostMapping()
    public LessonDto addLesson(@RequestBody Lesson lesson)
    {
        return lessonService.addLesson(lesson);
    }
    @DeleteMapping("/{lessonId}")
    public LessonDto lessonRemove(@PathVariable Long lessonId){
        return lessonService.removeLesson(lessonId);
    }
    @GetMapping()
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }

}
