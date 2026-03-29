package com.example.real.mapper;


import com.example.real.dto.StudentRequestDTO;
import com.example.real.dto.StudentResponseDTO;
import com.example.real.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    // method 1 dto to entity
    public Student toEntity(StudentRequestDTO dto){
        // create the object of student entity
        Student tempStudent = new Student();

        // take the data from dto and insert into tempStudent
        tempStudent.setAge(dto.getAge());
        tempStudent.setCity(dto.getCity());
        tempStudent.setCgpa(dto.getCgpa());
        tempStudent.setRollno(dto.getRollno());
        tempStudent.setName(dto.getName());

        return tempStudent;
    }

    // method 2 entity to dto
    public StudentResponseDTO toResponseDTO(Student s1){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        studentResponseDTO.setName(s1.getName());
        studentResponseDTO.setAge(s1.getAge());
        studentResponseDTO.setCgpa(s1.getCgpa());
        studentResponseDTO.setId(s1.getId());
        studentResponseDTO.setRollno(s1.getRollno());
        studentResponseDTO.setCity(s1.getCity());
        return studentResponseDTO;


    }





    // method 2 entity to dto



}
