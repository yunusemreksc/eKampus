package com.EKampus.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Advisor extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankNo;
    @ManyToMany
    private List<Student> studentList;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "advisorFaculty",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "facultyId"))
    private Set<Faculty> faculty=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Department.class)
    @JoinTable(name = "advisorDepartment",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> departments=new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Lesson.class)
    @JoinTable(name = "advisorLessons",joinColumns = @JoinColumn(name = "userId"),inverseJoinColumns = @JoinColumn(name = "lessonId"))
    private Set<Lesson> lessons=new HashSet<>();
}