package com.example.student.service.imp;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    @Override
    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(Student newStudent, int id) {
        return studentRepository.findById(id).map(student -> {
            student.setName(newStudent.getName());
            return studentRepository.save(student);
        }).orElseGet(()->{return null;});
    }

    @Override
    public Boolean deleteStudent(int id) {
        return studentRepository.findById(id).map(student -> {
            studentRepository.deleteById(student.getId());
            return true;
        }).orElseGet(()->{return false;});
    }

}
