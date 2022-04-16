package com.example.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudentEnrolment {
    @Id
    int id;
    @ManyToOne
    Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
