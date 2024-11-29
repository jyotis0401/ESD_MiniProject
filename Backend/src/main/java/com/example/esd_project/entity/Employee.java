//WE WILL NEED EMPLOYEE TABLE TO GET THE admin DEPARTMENT PEOPLE TO LOGIN.

package com.example.esd_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @Column(name="email", nullable = false, unique=true)
    private String email;
    @Column(name="password", nullable = false)
    private String password;
    @ManyToOne
    private Department department;
}

