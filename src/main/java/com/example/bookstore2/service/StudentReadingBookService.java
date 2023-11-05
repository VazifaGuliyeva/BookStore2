package com.example.bookstore2.service;

import com.example.bookstore2.entity.StudentReadingBook;

import java.util.List;

public interface StudentReadingBookService {


    List<StudentReadingBook> getAll();

    StudentReadingBook getById(int id);

    void delete(int id);

}
