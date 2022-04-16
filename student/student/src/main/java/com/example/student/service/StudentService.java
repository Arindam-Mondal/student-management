package com.example.student.service;

import com.example.student.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudent();
    public Student saveStudent(Student newStudent);
    public Student updateStudent(Student newStudent,int id);
    public Boolean deleteStudent(int id);
}
