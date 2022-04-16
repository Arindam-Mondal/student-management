package com.example.student.controller;

import com.example.student.Util.StudentUtil;
import com.example.student.controller.dto.StudentDto;
import com.example.student.model.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentUtil studentUtil;

    @GetMapping(value="/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }

    @PostMapping(value="/students")
    public ResponseEntity<Student> newStudent(@RequestBody StudentDto newStudent) {
        return new ResponseEntity<>(studentService.saveStudent(studentUtil.convertStudentDtopToStudent(newStudent)), HttpStatus.OK);
    }

    @PutMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody StudentDto newStudent) {
        Student student = studentService.updateStudent(studentUtil.convertStudentDtopToStudent(newStudent),id);
        return student == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping(value="/students/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id) {
        Boolean isDeleted = studentService.deleteStudent(id);
        return !isDeleted ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(HttpStatus.OK);
    }

}
