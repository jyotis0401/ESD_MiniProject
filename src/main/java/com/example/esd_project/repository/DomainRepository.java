package com.example.esd_project.repository;


//These repositories will extend JpaRepository,
// which provides built-in methods for CRUD operations and custom query support.

import com.example.esd_project.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, Long> {
    Domain findByProgramAndBatch(String program, int batch);
}
