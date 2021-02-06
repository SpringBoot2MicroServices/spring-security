package com.artech.springsecurity.controller;

import com.artech.springsecurity.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    List<Student> studentList = List.of(new Student(1202, "Raghu"),
            new Student(1555, "Sudhakar"));

    @GetMapping("{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId) {
        return studentList.stream().filter(student ->
                student.getStudentId().equals(studentId))
                .findFirst().orElseThrow(()
                -> new IllegalStateException("Student " + studentId + " does not exist"));
    }
}
