package com.example.testrestdbh2.dao;

import com.example.testrestdbh2.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Student> getAllStudents() {
        Query query = (Query) entityManager.createQuery("from Student");
        List<Student> allStudents = query.getResultList();
        return allStudents;
    }

    @Override
    public Student saveStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    public Student getStudent(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void deleteStudent(int id) {
        Query query = (Query) entityManager.createQuery("delete from Student " +
                " where id =: studentId");
        query.setParameter("studentId", id);
        query.executeUpdate();

    }
}
