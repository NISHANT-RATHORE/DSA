package com.example.security.Controller;

import com.example.security.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(new Student(1,"bhavna","meemroth","USER"), new Student(2,"nishika","Roy","USER")));

    @GetMapping("/student")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("S")
    public CsrfToken getCsrf(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("student")
    public Student postStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }
}
