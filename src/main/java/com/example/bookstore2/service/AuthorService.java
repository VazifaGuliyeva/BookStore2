package com.example.bookstore2.service;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.dto.AuthorPageResponse;
import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.request.AuthorRequest;
import com.example.bookstore2.entity.Author;

import java.util.List;

public interface AuthorService {

    AuthorPageResponse getAll(int page,int count);

    Author getById(int id);

    void delete(int id);

    void add(AuthorRequest request);
    Author getAuthorbyEmail(String email);
    void register(RegisterRequest request);

    String login(RegisterRequest request);
}
