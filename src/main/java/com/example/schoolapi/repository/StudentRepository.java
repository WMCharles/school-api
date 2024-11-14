package com.example.schoolapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.schoolapi.entity.Student;

public interface StudentRepository extends JpaRepository <Student, Long>{
}
