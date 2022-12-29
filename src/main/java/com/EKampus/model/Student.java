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
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentNo;
    private boolean studentType;
    private int semester;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "studentFaculty",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "facultyId"))
    private Set<Faculty> faculty=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Department.class)
    @JoinTable(name = "studentDepartment",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> departments=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Lesson.class)
    @JoinTable(name = "studentLessons",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private Set<Lesson> lessons=new HashSet<>();

}

