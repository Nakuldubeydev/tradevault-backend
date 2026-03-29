package com.example.real.service;

import com.example.real.dto.StudentRequestDTO;
import com.example.real.dto.StudentResponseDTO;
import com.example.real.exceptions.StudentNotFoundException;
import com.example.real.mapper.StudentMapper;
import com.example.real.model.Student;
import com.example.real.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository objectStudentRepository;

    @Autowired
    private StudentMapper studentMapper;  // ← inject mapper!

    // CREATE
    public StudentResponseDTO saveStudent(StudentRequestDTO dto) {
        Student student = studentMapper.toEntity(dto);
        Student saved = objectStudentRepository.save(student);
        return studentMapper.toResponseDTO(saved);
    }

    // READ ALL
    public List<StudentResponseDTO> getAllStudents() {
        return objectStudentRepository.findAll()
                .stream()
                .map(studentMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public StudentResponseDTO getStudentById(Long id) {
        Student student = objectStudentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        return studentMapper.toResponseDTO(student);
    }

    // DELETE
    public void delete(Long SID) {
        objectStudentRepository.findById(SID)
                .orElseThrow(() -> new StudentNotFoundException(SID));
        objectStudentRepository.deleteById(SID);
    }

    // UPDATE
    public StudentResponseDTO updateStudent(Long SID, StudentRequestDTO dto) {
        Student existing = objectStudentRepository.findById(SID)
                .orElseThrow(() -> new StudentNotFoundException(SID));
        existing.setName(dto.getName());
        existing.setAge(dto.getAge());
        existing.setCgpa(dto.getCgpa());
        existing.setCity(dto.getCity());
        existing.setRollno(dto.getRollno());
        return studentMapper.toResponseDTO(objectStudentRepository.save(existing));
    }
}