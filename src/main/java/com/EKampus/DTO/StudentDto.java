package com.EKampus.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {
    private int semester;
    private String studentNo;
    private String name;
    private String surname;
    private boolean gender;
    private String email;
    private String phoneNo;
}
