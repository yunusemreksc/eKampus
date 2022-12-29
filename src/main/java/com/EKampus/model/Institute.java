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
public class Institute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String instituteName;
    private String instituteAdminName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Faculty.class)
    @JoinTable(name = "instituteStudent",joinColumns = @JoinColumn(name = "instituteId"),inverseJoinColumns = @JoinColumn(name = "userId"))
    private Set<Student> students=new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Department.class)
    @JoinTable(name = "instituteDepartment",joinColumns = @JoinColumn(name = "instituteId"),inverseJoinColumns = @JoinColumn(name = "departmentId"))
    private Set<Department> departments=new HashSet<>();
}
