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
public class Hr extends Person{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bankNo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = StudentAffairs.class)
    @JoinTable(name = "HrStudentAffairsId",joinColumns = @JoinColumn(name = "HrId"),inverseJoinColumns = @JoinColumn(name = "studentAffairsId"))
    private Set<StudentAffairs> studentAffairsSet=new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Advisor.class)
    @JoinTable(name = "HrAdvisor",joinColumns = @JoinColumn(name = "Hr"),inverseJoinColumns = @JoinColumn(name = "advisorId"))
    private Set<Advisor> advisorSet =new HashSet<>();

}
