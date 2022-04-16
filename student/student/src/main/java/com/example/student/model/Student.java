package com.example.student.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="student") // maybe CascadeType.REMOVE is enough for you
    private List<StudentEnrolment> studentEnrolments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEnrolment> getStudentEnrolments() {
        return studentEnrolments;
    }

    public void setStudentEnrolments(List<StudentEnrolment> studentEnrolments) {
        this.studentEnrolments = studentEnrolments;
    }
}
