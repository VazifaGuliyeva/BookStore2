package com.example.bookstore2.controller;

import com.example.bookstore2.entity.StudentReadingBook;
import com.example.bookstore2.service.StudentReadingBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/studentReadingBooks")
@AllArgsConstructor
public class StudentReadingBookReadingController {
    private final StudentReadingBookService studentReadingBookService;
    @GetMapping
    public List<StudentReadingBook> getAll(){
        return studentReadingBookService.getAll();
    }
    @GetMapping("/{id}")
    public StudentReadingBook getById(int id){
        return studentReadingBookService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(int id){
        studentReadingBookService.delete(id);
    }
}
