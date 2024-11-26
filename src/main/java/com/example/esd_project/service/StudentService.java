package com.example.esd_project.service;

import com.example.esd_project.dto.StudentsDTO;
import com.example.esd_project.entity.Domain;
import com.example.esd_project.entity.Student;
import com.example.esd_project.mapper.StudentMapper;
import com.example.esd_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    public List<StudentsDTO> getStudentsByProgramAndBatch(String program, int batch) {
        //we will get list of data from repo here

        //list of entities of students
        List<Student> studentsList = studentRepository.findByDomain_ProgramAndDomain_Batch(program, batch);
        return studentMapper.studentsToStudentsDTO(studentsList);
    }
}
