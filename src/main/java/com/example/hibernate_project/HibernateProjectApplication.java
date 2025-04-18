package com.example.hibernate_project;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.hibernate_project.Services.StudentService;
import com.example.hibernate_project.Services.CourseService;
@SpringBootApplication
public class HibernateProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}
		@Bean
		public CommandLineRunner run(StudentService s1, CourseService c1){
			return args -> {
				s1.Create_Student();
				s1.Create_Student();
				s1.Create_Student();
				c1.AddCourse();
				c1.AddCourse();
				c1.AddCourse();
				System.out.println(s1.Get_Students());
				System.out.println(c1.Get_Courses());
			};
	}
}
