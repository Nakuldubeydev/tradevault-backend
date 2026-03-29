package com.example.real.dto;

import lombok.Data;

@Data
public class StudentRequestDTO {
    // only safe fields
    private String name;
    private int age;
    private String cgpa;
    private String city;
    private int rollno;


}
