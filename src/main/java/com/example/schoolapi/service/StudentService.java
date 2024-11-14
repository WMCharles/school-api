package com.example.schoolapi.service;

import java.util.List;

import com.example.schoolapi.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    void deleteStudent(Long id);

    Student updateStudent(Long id, Student student);
}
