package com.EKampus.model;


import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class Person {
    private String name;
    private String surname;
    private String tc;
    private String email;
    private String password;
    private String phoneNo;
    private Date birthDate;
    private boolean gender;

}
