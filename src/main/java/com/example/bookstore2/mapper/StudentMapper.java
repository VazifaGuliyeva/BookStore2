package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.StudentDto;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Student;
import com.example.bookstore2.security.AuthorDetails;
import com.example.bookstore2.security.StudentDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentDto toStudentDto(Student student);

    Student toStudentEntity(StudentDto studentDto);
    StudentDetails toStudentDetails(Student student);

    Student toUserFromRegisterRequest(RegisterRequest request);
}
