package com.example.hibernate_project.Services;
import com.example.hibernate_project.Entities.Courses;
import com.example.hibernate_project.Repositories.CourseRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Scanner;
@Service
@Transactional
public class CourseService {
    Scanner sc = new Scanner(System.in);
    private final CourseRepositories courseRepositories;
    @Autowired
    public CourseService(CourseRepositories c) {
        this.courseRepositories = c;
    }

    public void AddCourse() {
        Courses c1 = new Courses();
        System.out.println("Enter Course Name : ");
        String name = sc.nextLine();
        c1.setName(name);
        courseRepositories.save(c1);
    }
    public List<Courses> Get_Courses() {
        return courseRepositories.findAll();
    }

    public long Count() {
        return courseRepositories.count();
    }

    public void delete(Long Id) {
        courseRepositories.deleteById(Id);
    }

    public boolean Check(Long id) {
        return courseRepositories.existsById(id);
    }
}