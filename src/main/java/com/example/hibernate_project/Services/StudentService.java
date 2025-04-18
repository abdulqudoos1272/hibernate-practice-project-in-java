package com.example.hibernate_project.Services;
import com.example.hibernate_project.Entities.Student;
import com.example.hibernate_project.Repositories.StudentRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Scanner;
import java.util.List;
@Service
@Transactional
public class StudentService {
    private final StudentRepositories studentRepositories;
    @Autowired
    public StudentService(StudentRepositories s1){
        studentRepositories=s1;
    }
    Scanner sc=new Scanner(System.in);
    public void Create_Student(){
        Student s1=new Student();
        System.out.println("Enter Student Name : ");
        String name=sc.nextLine();
        s1.setName(name);
        System.out.println("Enter Age");
        int age=sc.nextInt();
        s1.setAge(age);
        sc.nextLine();
        System.out.println("Enter Gender");
        String gender=sc.nextLine();
        s1.setGender(gender);
        studentRepositories.save(s1);
    }
    public void update(Long id){
        Student s1=get_Single_Student(id);
        System.out.println("Enter Student Name : ");
        String name=sc.nextLine();
        s1.setName(name);
        System.out.println("Enter Age");
        int age=sc.nextInt();
        s1.setAge(age);
        System.out.println("Enter Gender");
        String gender=sc.nextLine();
        s1.setGender(gender);
        studentRepositories.save(s1);
    }
    public List<Student> Get_Students(){
        return studentRepositories.findAll();
    }
    public Student get_Single_Student(Long id){
        return studentRepositories.findById(id).orElse(null);
    }
    public List<Student> GetLessAge(int age){
        return studentRepositories.findByAge(age);
    }
    public List<Student> GetGender(String gender){
        return studentRepositories.findByGender(gender);
    }
    public long Count(){
        return studentRepositories.count();
    }
    public void Delete_Student(Long Id){
        studentRepositories.deleteById(Id);
    }
    public boolean Check(Long id){
        return studentRepositories.existsById(id);
    }
};

