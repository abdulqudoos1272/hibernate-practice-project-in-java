package com.example.hibernate_project.Repositories;
import com.example.hibernate_project.Entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseRepositories extends JpaRepository<Courses,Long> {
}
