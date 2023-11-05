package com.example.bookstore2.service;

import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.StudentDto;
import com.example.bookstore2.dto.StudentPageResponse;
import com.example.bookstore2.dto.request.AuthorRequest;
import com.example.bookstore2.dto.request.StudentRequest;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Student;

import java.util.List;

public interface StudentService {
    StudentPageResponse getAll(int page,int count);

    Student getById(int id);

    void delete(int id);
    void add(StudentRequest request);
    Student getStudentByEmail(String email);
    void register(RegisterRequest request);

    String login(RegisterRequest request);
}
