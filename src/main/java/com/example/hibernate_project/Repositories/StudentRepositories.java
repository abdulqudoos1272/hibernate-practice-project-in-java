package com.example.hibernate_project.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hibernate_project.Entities.Student;
import java.util.List;
public interface StudentRepositories extends JpaRepository<Student,Long> {
    List<Student> findByAge(int age);
    List<Student> findByGender(String gender);
}
