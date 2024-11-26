

package com.example.esd_project.entity;

import jakarta.persistence.*;
import lombok.*;
//HOW TO VALIDATE
//import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;



    @Column(name="firstName",nullable = false)
    private String firstName;
    @Column(name="lastName",nullable = false)
    private String lastName;
    @Column(name="email",nullable = false, unique = true)
    //javax.validation.constraints.Email
    private String email;
    @Column(name="rollNumber",nullable = false, unique = true)
    private  int rollNumber;
    @Column(name="cgpa",nullable = false)
    //@javax.validation.constraints.DecimalMin("0.0")
    //@javax.validation.constraints.DecimalMax("10.0")
    private double cgpa;

    @ManyToOne
    @JoinColumn(name = "domain_id", nullable = false)
    private Domain domain;

//DOMAIN TO CONNECT TO THE DOMAIN TABLE AND STUDENT TABLE



    //what is this
    //6. Unidirectional vs. Bidirectional Relationship
    //Currently, the relationship between Student and Domain is unidirectional (Student to Domain).
    //If the Domain entity needs to know about its associated students, you should add a bidirectional relationship in the Domain class.
    //Optional Fix (in Domain class):
    //
    //@OneToMany(mappedBy = "domain", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Student> students;
}
