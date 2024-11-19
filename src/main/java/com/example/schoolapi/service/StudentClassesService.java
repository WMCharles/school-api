package com.example.schoolapi.service;

import java.util.List;

import com.example.schoolapi.dto.StudentClassRequest;
import com.example.schoolapi.entity.StudentClasses;

public interface StudentClassesService {

    List<StudentClasses> getAllStudentClasses();

    StudentClasses getStudentClassesById(Long id);

    StudentClasses createStudentClass(StudentClassRequest request);

    StudentClasses saveStudentClasses(StudentClasses studentClasses);

    StudentClasses upStudentClasses(Long id, StudentClasses studentClasses);

    void deleteStudentClasses(Long id);
}
