package com.example.hibernate_project.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hibernate_project.Entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentRepositories extends JpaRepository<Student,Long> {
    //Simple Query
    @Query("select s from Student s where s.gender= :gen")
    List<Student> findByGender(String gen);
    //Native Query
    @Query(value = "Select *from student_table where student_age>:age",nativeQuery = true)
    List<Student> findByAge(int age);
    //Modifying Query
    @Modifying
    @Query("update Student s set s.gender = :gen where s.id=:id")
    int updateStudentGender(@Param("id") Long id,@Param("gen") String gen);
    @Modifying
    @Query("delete from Student s where s.id=:id")
    int Delete(@Param("id") Long id);
}
