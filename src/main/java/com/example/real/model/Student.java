package com.example.real.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Student {

    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int rollno;
    private String name;
    private int age;
    private String cgpa;
    private String city;


}
