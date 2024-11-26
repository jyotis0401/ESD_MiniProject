package com.example.esd_project.repository;
/*
Repositories in Spring Boot are interfaces that extend JpaRepository
 or other Spring Data repository interfaces, and they provide built-in CRUD
 functionality without requiring boilerplate code.
 */

/*
Key Features Provided by JpaRepository:
save(Domain domain): Saves or updates a Domain object.
findById(Long id): Finds a Domain by its id.
findAll(): Retrieves all Domain records from the database.
deleteById(Long id): Deletes a Domain record by its id.
 */

import com.example.esd_project.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Custom query method, otional- to avoid null pointer exception

    Employee findByEmail(String email);
    // For authentication
}

