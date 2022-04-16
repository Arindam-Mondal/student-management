package com.example.student.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    int id;
    String courseName;

    @ManyToMany
    @JoinTable(
            name = "student_enrolment",
            joinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    )
    private List<Student> students = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy="COURSE_ID") // maybe CascadeType.REMOVE is enough for you
//    private List<StudentEnrolment> studentEnrolments = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public List<StudentEnrolment> getStudentEnrolments() {
//        return studentEnrolments;
//    }
//
//    public void setStudentEnrolments(List<StudentEnrolment> studentEnrolments) {
//        this.studentEnrolments = studentEnrolments;
//    }
}
