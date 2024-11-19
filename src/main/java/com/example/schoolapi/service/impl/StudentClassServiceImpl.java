package com.example.schoolapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.schoolapi.dto.StudentClassRequest;
import com.example.schoolapi.entity.Darasa;
import com.example.schoolapi.entity.Student;
import com.example.schoolapi.entity.StudentClasses;
import com.example.schoolapi.repository.DarasaRepository;
import com.example.schoolapi.repository.StudentClassesRepository;
import com.example.schoolapi.repository.StudentRepository;
import com.example.schoolapi.service.StudentClassesService;

@Service
public class StudentClassServiceImpl implements StudentClassesService {

    @Autowired
    private StudentClassesRepository studentClassesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DarasaRepository darasaRepository;

    @Override
    public List<StudentClasses> getAllStudentClasses() {
        return studentClassesRepository.findAll();
    }

    @Override
    public StudentClasses getStudentClassesById(Long id) {
        return studentClassesRepository.findById(id).orElse(null);
    }

    @Override
    public StudentClasses saveStudentClasses(StudentClasses studentClasses) {
        return studentClassesRepository.save(studentClasses);
    }

    @Override
    public StudentClasses createStudentClass(StudentClassRequest request) {
        // Fetch Student and Darasa
        Student student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + request.getStudentId()));

        Darasa darasa = darasaRepository.findById(request.getDarasaId())
                .orElseThrow(() -> new RuntimeException("Darasa not found with id: " + request.getDarasaId()));

        // Create StudentClasses entity
        StudentClasses studentClass = new StudentClasses();
        studentClass.setStudent(student);
        studentClass.setDarasa(darasa);
        studentClass.setYear(request.getYear());

        return studentClassesRepository.save(studentClass);
    }

    @Override
    public StudentClasses upStudentClasses(Long id, StudentClasses studentClasses) {
        StudentClasses existingStudentClasses = studentClassesRepository.findById(id).orElse(null);
        if (existingStudentClasses != null) {
            existingStudentClasses.setDarasa(studentClasses.getDarasa());
            existingStudentClasses.setStudent(studentClasses.getStudent());
            return studentClassesRepository.save(existingStudentClasses);
        }
        return null;
    }

    @Override
    public void deleteStudentClasses(Long id) {
        studentClassesRepository.deleteById(id);
    }
}
