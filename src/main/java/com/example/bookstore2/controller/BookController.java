package com.example.bookstore2.controller;

import com.example.bookstore2.dto.request.BookRequest;
import com.example.bookstore2.dto.response.BookAllResponse;
import com.example.bookstore2.entity.Book;
import com.example.bookstore2.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;
    @GetMapping
    public List<BookAllResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public Book getById(@PathVariable int id){
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.delete(id);
    }
    @PostMapping
    public ResponseEntity<Void> add(@RequestBody BookRequest request){
        service.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
