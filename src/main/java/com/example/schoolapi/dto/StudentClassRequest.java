package com.example.schoolapi.dto;

import lombok.Data;

@Data
public class StudentClassRequest {
    private Long studentId;
    private Long darasaId;
    private Integer year;
}
