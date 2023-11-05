package com.example.bookstore2.impl;

import com.example.bookstore2.entity.StudentReadingBook;
import com.example.bookstore2.repository.StudentReadingBookRepository;
import com.example.bookstore2.service.StudentReadingBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentReadingBookImpl implements StudentReadingBookService{
    private final StudentReadingBookRepository studentReadingBookRepository;

    @Override
    public List<StudentReadingBook> getAll() {
        return studentReadingBookRepository.findAll();
    }

    @Override
    public StudentReadingBook getById(int id) {
        return studentReadingBookRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        studentReadingBookRepository.deleteById(id);

    }
}
