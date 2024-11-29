package com.example.esd_project.service;



import com.example.esd_project.dto.LoginRequest;
import com.example.esd_project.entity.Employee;
import com.example.esd_project.helper.JWTHelper;
import com.example.esd_project.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTHelper jwtHelper;
//    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Save employee with hashed password
    public Employee saveEmployee(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return employeeRepository.save(employee);
    }

    // Validate credentials during login
    public String validateCredentials(LoginRequest request) {
        Employee employee = findByEmail(request.email());
        //since email is private we need funtion to access but it is done auto.

//        if(employee != null && employee.getPassword().equals(request.password())){
        if(employee != null && passwordEncoder.matches(request.password(), employee.getPassword())) {
            return jwtHelper.generateToken(employee.getEmail(), employee.getDepartment().getDepartmentName());
        }
        return "wrong password";
    }

    // Find employee by email
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }
}


