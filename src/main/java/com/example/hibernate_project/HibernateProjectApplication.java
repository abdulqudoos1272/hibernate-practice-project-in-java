package com.example.hibernate_project;

import com.example.hibernate_project.Services.StudentService;
import com.example.hibernate_project.Services.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class HibernateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StudentService studentService, CourseService courseService) {
		return args -> {
			Scanner sc = new Scanner(System.in);
			int choice = -1;

			do {
				System.out.println("\n========= STUDENT & COURSE MENU =========");
				System.out.println("1. Create Student");
				System.out.println("2. Update Student (Full)");
				System.out.println("3. Get All Students");
				System.out.println("4. Get Single Student");
				System.out.println("5. Get Students By Age");
				System.out.println("6. Get Students By Gender");
				System.out.println("7. Count Students");
				System.out.println("8. Delete Student");
				System.out.println("9. Update Student Gender");
				System.out.println("10. Delete Student By Custom");
				System.out.println("11. Create Course");
				System.out.println("12. Get All Courses");
				System.out.println("13. Assign Course to Student");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine();  // consume leftover newline

				switch (choice) {
					case 1 -> studentService.Create_Student();
					case 2 -> {
						System.out.print("Enter Student ID: ");
						Long id = sc.nextLong();
						sc.nextLine();
						studentService.update(id);
					}
					case 3 -> studentService.Get_Students().forEach(System.out::println);
					case 4 -> {
						System.out.print("Enter Student ID: ");
						Long id = sc.nextLong();
						sc.nextLine();
						System.out.println(studentService.get_Single_Student(id));
					}
					case 5 -> {
						System.out.print("Enter Age: ");
						int age = sc.nextInt();
						sc.nextLine();
						studentService.GetLessAge(age).forEach(System.out::println);
					}
					case 6 -> {
						System.out.print("Enter Gender: ");
						String gender = sc.nextLine();
						studentService.GetGender(gender).forEach(System.out::println);
					}
					case 7 -> System.out.println("Total Students: " + studentService.Count());
					case 8 -> {
						System.out.print("Enter Student ID to Delete: ");
						Long id = sc.nextLong();
						sc.nextLine();
						studentService.Delete_Student(id);
					}
					case 9 -> {
						System.out.print("Enter Student ID: ");
						Long id = sc.nextLong();
						sc.nextLine();
						System.out.print("Enter New Gender: ");
						String gender = sc.nextLine();
						int updated = studentService.update(id, gender);
						System.out.println(updated + " student(s) updated.");
					}
					case 10 -> {
						System.out.print("Enter Student ID for Custom Delete: ");
						Long id = sc.nextLong();
						sc.nextLine();
						int deleted = studentService.Del(id);
						System.out.println(deleted + " student(s) deleted.");
					}
					case 0 -> System.out.println("Exiting... Bye!");
					default -> System.out.println("Invalid choice. Try again.");
				}
			} while (choice != 0);

			sc.close();
		};
	}
}
