package com.example.schoolapi.entity;//-

import java.util.HashSet;
// import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    // @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<StudentClasses> studentClasses;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentClasses> studentClasses = new HashSet<>();
}
