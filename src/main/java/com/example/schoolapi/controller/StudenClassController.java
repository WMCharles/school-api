package com.example.schoolapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.schoolapi.dto.StudentClassRequest;
import com.example.schoolapi.entity.StudentClasses;
import com.example.schoolapi.service.StudentClassesService;

@RestController
@RequestMapping("/api/student-classes")
public class StudenClassController {

    @Autowired
    private StudentClassesService studentClassService;

    @GetMapping
    public List<StudentClasses> getAllStudentClasses() {
        return studentClassService.getAllStudentClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentClasses> getStudentClassesById(@PathVariable Long id) {
        return ResponseEntity.ok(studentClassService.getStudentClassesById(id));
    }

    @PostMapping
    public ResponseEntity<StudentClasses> createStudentClass(@RequestBody StudentClassRequest request) {
        StudentClasses studentClass = studentClassService.createStudentClass(request);
        return ResponseEntity.ok(studentClass);
    }

    // @PostMapping
    // public ResponseEntity<StudentClasses> saveStudentClasses(@RequestBody StudentClasses studentClass) {
    //     return ResponseEntity.ok(studentClassService.saveStudentClasses(studentClass));
    // }

    @PutMapping("/{id}")
    public ResponseEntity<StudentClasses> updateStudent(@PathVariable Long id,
            @RequestBody StudentClasses studentClass) {
        return ResponseEntity.ok(studentClassService.upStudentClasses(id, studentClass));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentClasses> patchStudentClasses(@PathVariable Long id,
            @RequestBody StudentClasses studentClass) {
        return ResponseEntity.ok(studentClassService.upStudentClasses(id, studentClass));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentClass(@PathVariable Long id) {
        studentClassService.deleteStudentClasses(id);
        return ResponseEntity.noContent().build();
    }
}
