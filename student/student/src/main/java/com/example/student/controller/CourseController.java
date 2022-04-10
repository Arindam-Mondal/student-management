package com.example.student.controller;

import com.example.student.model.Course;
import com.example.student.model.Student;
import com.example.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(value="/courses")
    public ResponseEntity<List<Course>> getAllStudent() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK);
    }
}
