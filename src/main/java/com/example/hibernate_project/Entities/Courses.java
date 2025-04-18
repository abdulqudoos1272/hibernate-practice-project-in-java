package com.example.hibernate_project.Entities;
import jakarta.persistence.*;
@Entity
@Table(name = "Courses_Table")
public class Courses {
    @Id
    @Column(name = "Course_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Course_Name",nullable = false,length = 25)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return " Course ID : "+id+"  Course Name : "+name;
    }
}