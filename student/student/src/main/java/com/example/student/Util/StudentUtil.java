package com.example.student.Util;

import com.example.student.controller.dto.StudentDto;
import com.example.student.model.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentUtil {

    private ModelMapper modelMapper = new ModelMapper();

    public Student convertStudentDtopToStudent(StudentDto studentDTO) {
        return modelMapper.map(studentDTO,Student.class);
    }
}
