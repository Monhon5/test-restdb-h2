package com.example.testrestdbh2.service;

import com.example.testrestdbh2.dao.StudentDAO;
import com.example.testrestdbh2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDAO studentDAO;
    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentDAO.saveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentDAO.getStudent(id);
    }

    @Override
    public void deleteStudent(int id) {
studentDAO.deleteStudent(id);
    }
}
