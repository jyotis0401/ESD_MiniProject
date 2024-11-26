package com.example.esd_project.entity;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.spi.NamingManager;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "domain")
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId; //primary key

    @Column(name="program",nullable = false) //neeed not unique because batch can be different
    private String program;
    @Column(name="batch",nullable = false)
    private int batch;
    @Column(name="capacity",nullable = false)
    private int capacity;
    @Column(name="qualification",nullable = false)
    private String qualification;

    @OneToMany
    List<Student> students;



    //WE DONT NEED GETTER AND SETTER BECAUSE WE ARE USING LOMBOK @DATA AND BUILDERS
//    // Getters and Setters
//    public Long getDomainId() { return domainId; }
//    public void setDomainId(Long domainId) { this.domainId = domainId; }
//    public String getProgram() { return program; }
//    public void setProgram(String program) { this.program = program; }
//    public int getBatch() { return batch; }
//    public void setBatch(int batch) { this.batch = batch; }
//    public int getCapacity() { return capacity; }
//    public void setCapacity(int capacity) { this.capacity = capacity; }
//    public String getQualification() { return qualification; }
//    public void setQualification(String qualification) { this.qualification = qualification; }
}
