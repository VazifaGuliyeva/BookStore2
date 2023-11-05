package com.example.bookstore2.service;

import com.example.bookstore2.dto.request.BookRequest;
import com.example.bookstore2.dto.response.BookAllResponse;
import com.example.bookstore2.entity.Book;

import java.util.List;

public interface BookService {

    List<BookAllResponse> getAll();

    Book getById(int id);

    void delete(int id);

    void add(BookRequest request);
}
