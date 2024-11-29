package com.example.esd_project.repository;

import com.example.esd_project.entity.Domain;
import com.example.esd_project.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    /*
    Spring Data JPA uses method name conventions to generate the corresponding SQL query.
     In this case, it translates to sql
    SELECT * FROM students WHERE domain_id = ?;
     */


    ////SOMETHING IS WRONG WITH DOMAIN ID THING

    List<Student> findByDomain_ProgramAndDomain_Batch(String program, int batch);
    // Method to fetch students by domain
}


