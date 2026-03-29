package com.example.real.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    // add my id
    private Long id;

    private String name;
    private String city;
    private String cgpa;
    private int rollno;
    private int age;

}
