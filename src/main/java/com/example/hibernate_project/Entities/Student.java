package com.example.hibernate_project.Entities;
import jakarta.persistence.*;
import java.lang.classfile.instruction.LineNumber;
@Entity
@Table(name = "Student_Table")
public class Student {
    @Id
    @Column(name = "Student_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Student_Name",nullable = false,length = 25)
    private String name;
    @Column(name = "Student_Gender")
    private String gender;
    @Column(name = "Student_Age")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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
}