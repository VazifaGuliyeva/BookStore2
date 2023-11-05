package com.example.bookstore2.controller;

import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.StudentDto;
import com.example.bookstore2.dto.StudentPageResponse;
import com.example.bookstore2.dto.request.AuthorRequest;
import com.example.bookstore2.dto.request.StudentRequest;
import com.example.bookstore2.entity.Student;
import com.example.bookstore2.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    @GetMapping
    public StudentPageResponse getAll(@RequestParam(value="page")int page, @RequestParam(value="count") int count){
        return service.getAll(page, count);
    }
    @GetMapping("/{id}")
    public Student getById(@PathVariable int id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody StudentRequest request){
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void register(@RequestBody @Valid RegisterRequest request) {
        service.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid RegisterRequest request) {
        return service.login(request);
    }

}
