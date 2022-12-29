package com.EKampus.service;

import com.EKampus.DTO.LessonDto;
import com.EKampus.model.Lesson;
import com.EKampus.repository.LessonRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepo lessonRepo;

    public LessonService(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    public LessonDto addLesson(Lesson lesson) {
        Lesson savedLesson = lessonRepo.save(lesson);
        return new LessonDto(
                savedLesson.getLessonName(),
                savedLesson.getCredit(),
                savedLesson.isOptionalOrCompulsory()
        );
    }
    public LessonDto removeLesson(Long lessonId) {
        Lesson savedLesson = lessonRepo.findById(lessonId).get();
        lessonRepo.delete(savedLesson);
        return new LessonDto(savedLesson.getLessonName(),savedLesson.getCredit(),savedLesson.isOptionalOrCompulsory());
    }
    public Lesson getLesson(Long lessonId){
        return lessonRepo.findById(lessonId).get();
    }
    public List<Lesson> getAllLessons() {
        return lessonRepo.findAll();
    }

}
