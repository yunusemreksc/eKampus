package com.EKampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LessonDto {
    private String lessonName;
    private int credit;
    private boolean optionalOrCompulsory;
}
