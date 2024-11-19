package com.example.schoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolapi.entity.StudentClasses;

public interface StudentClassesRepository extends JpaRepository<StudentClasses, Long> {

}
