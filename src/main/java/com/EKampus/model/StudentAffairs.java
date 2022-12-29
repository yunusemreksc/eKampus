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
public class StudentAffairs extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bankNo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "studentAffairsStudent",joinColumns = @JoinColumn(name = "studentAffairsId"),inverseJoinColumns = @JoinColumn(name = "studentId"))
    private Set<Student> students=new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Department.class)
    @JoinTable(name = "studentAffairs_department",joinColumns = @JoinColumn(name = "studentAffairsId"),inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> departments=new HashSet<>();


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="facultyId")
    private Faculty faculty;
    private boolean facultyOrInstitute;
}
