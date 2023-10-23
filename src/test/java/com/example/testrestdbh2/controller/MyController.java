package com.example.testrestdbh2.controller;

import com.example.testrestdbh2.entity.Student;
import com.example.testrestdbh2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudents() {
         List<Student> allStudents = studentService.getAllStudents();
         return allStudents;

    }

    @GetMapping("/students/{id}")
    private Student getStudents(@PathVariable("id") int id) {
        return studentService.getStudent(id);

    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return student;
    }
    @DeleteMapping
    public void updateStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
