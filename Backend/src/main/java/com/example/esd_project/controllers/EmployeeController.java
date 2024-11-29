package com.example.esd_project.controllers;

import com.example.esd_project.dto.LoginRequest;
import com.example.esd_project.dto.StudentsDTO;
import com.example.esd_project.dto.domainRequest;
import com.example.esd_project.dto.domainResponse;
import com.example.esd_project.entity.Domain;
import com.example.esd_project.entity.Employee;
import com.example.esd_project.helper.JWTHelper;
import com.example.esd_project.service.DomainService;
import com.example.esd_project.service.EmployeeService;
import com.example.esd_project.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class EmployeeController {

    @Autowired
    private JWTHelper jwtHelper;

    @Autowired
    private EmployeeService employeeService;

    // Login API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest request) {
        String token = employeeService.validateCredentials(request);
        return ResponseEntity.ok(token);
    }

    @Autowired
    private DomainService domainService;


    @PostMapping("/NewDomain")
    public ResponseEntity<String> newDomain(@RequestBody @Valid domainRequest request, @RequestHeader("Authorization") String bearerToken) {
        if(!checkAuthorization(bearerToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized");
        }
        return ResponseEntity.ok(domainService.createDomain(request));
    }

    @GetMapping("/GetAllDomain")
    //here we want to return list of domains so change the type;
    public ResponseEntity<?> getAllDomain(@RequestHeader("Authorization") String bearerToken) {
        if(!checkAuthorization(bearerToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized");
        }
        return ResponseEntity.ok(domainService.getdomainsall());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @PutMapping("update/{program}/{batch}")
    public ResponseEntity<String> updateDomain(@PathVariable String program, @PathVariable int batch, @RequestBody domainRequest updatedDomain
            , @RequestHeader("Authorization") String bearerToken) {
        if(!checkAuthorization(bearerToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized");
        }
        return ResponseEntity.ok(domainService.updateDomain(program, batch, updatedDomain));
    }



    @Autowired
    private StudentService studentService;

    @GetMapping("/{program}/{batch}")
    public ResponseEntity<?> getstudentsbyprogramandbatch(@PathVariable String program, @PathVariable int batch
            , @RequestHeader("Authorization") String bearerToken) {
        if(!checkAuthorization(bearerToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized");
        }
        List<StudentsDTO> students = studentService.getStudentsByProgramAndBatch(program, batch);
        return ResponseEntity.ok(students);
    }

    public boolean checkAuthorization(String bearerToken) {
        if(bearerToken == null || bearerToken.isBlank() || !bearerToken.startsWith("Bearer ")) {
            return false;
        }
        String token = bearerToken.substring(7);
        if(token.isBlank()) {
            return false;
        }

        return jwtHelper.validateToken(token);
    }

}







