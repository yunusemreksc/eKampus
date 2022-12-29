package com.EKampus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;
    private boolean instituteOrFaculty;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "departmentStudent",joinColumns = @JoinColumn(name = "departmentId"),inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<Student> students=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Lesson.class)
    @JoinTable(name = "departmentLessons",joinColumns = @JoinColumn(name = "departmentId"),inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private Set<Lesson> lessons=new HashSet<>();



}
