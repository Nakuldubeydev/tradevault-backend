package com.example.real.controller;


import com.example.real.dto.StudentRequestDTO;
import com.example.real.dto.StudentResponseDTO;
import com.example.real.model.Student;
import com.example.real.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class StudentController {
    // worker
    @Autowired
    private StudentService objectStudentService;


    // CREATE
    @PostMapping("/create/student")
    public ResponseEntity<StudentResponseDTO> createStudent(
            @RequestBody StudentRequestDTO dto) {
        log.info("POST API HIT");
        StudentResponseDTO saved = objectStudentService.saveStudent(dto);
        log.info("student created: {}", saved);
        return ResponseEntity.status(201).body(saved);
    }

    // READ ALL
    @GetMapping("/students")
    public ResponseEntity<List<StudentResponseDTO>> getAllStudents() {
        log.info("GET ALL API HIT");
        List<StudentResponseDTO> temp = objectStudentService.getAllStudents();
        return ResponseEntity.ok(temp);
    }

    // GET BY ID
    @GetMapping("/students/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id) {
        log.info("GET BY ID HIT: {}", id);
        return ResponseEntity.ok(objectStudentService.getStudentById(id));
    }

    // DELETE
    @DeleteMapping("/delete/students/{SID}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long SID) {
        log.info("DELETE HIT: {}", SID);
        objectStudentService.delete(SID);
        return ResponseEntity.ok("Student " + SID + " deleted!");
    }

    // UPDATE
    @PutMapping("/update/students/{SID}")
    public ResponseEntity<StudentResponseDTO> updateStudent(
            @PathVariable Long SID,
            @RequestBody StudentRequestDTO dto) {
        log.info("UPDATE HIT: {}", SID);
        return ResponseEntity.ok(objectStudentService.updateStudent(SID, dto));
    }
}
