package com.example.bookstore2.dto;

import com.example.bookstore2.entity.Student;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class StudentDtoManager implements Function<Student,StudentDto> {
    @Override
    public StudentDto apply(Student student) {
        return new StudentDto(student.getStudentName(),student.getBirthDate(),student.getEmail());
    }
}
