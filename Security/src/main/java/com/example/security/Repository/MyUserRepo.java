package com.example.security.Repository;

import com.example.security.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepo extends JpaRepository<Student, Integer> {
    Student findByUsername(String username);
}