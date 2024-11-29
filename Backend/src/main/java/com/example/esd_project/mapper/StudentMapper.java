package com.example.esd_project.mapper;


import com.example.esd_project.dto.StudentsDTO;
import com.example.esd_project.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {


    public StudentsDTO toStudentsDTO(Student student) {
        return new StudentsDTO(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getRollNumber(),
                student.getCgpa()
        );
    }

    public List<StudentsDTO> studentsToStudentsDTO(List<Student> students) {
        List<StudentsDTO> studentsDTOList = new ArrayList<>();
        for (Student student : students) {
            studentsDTOList.add(toStudentsDTO(student));
        }
        return studentsDTOList;
    }
}

//we cannot use @builder in record so we need constructior - because records doesnot allow setter only getter.