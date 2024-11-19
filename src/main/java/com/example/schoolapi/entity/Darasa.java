package com.example.schoolapi.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "darasas")
public class Darasa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    // @OneToMany(mappedBy = "darasa", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<StudentClasses> studentClasses;

    @OneToMany(mappedBy = "darasa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentClasses> studentClasses = new HashSet<>();
}
