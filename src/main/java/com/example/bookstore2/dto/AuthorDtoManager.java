package com.example.bookstore2.dto;

import com.example.bookstore2.entity.Author;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class AuthorDtoManager implements Function<Author,AuthorDto> {
    @Override
    public AuthorDto apply(Author author) {
        return new AuthorDto(author.getAuthorName(),author.getBirthDate(),author.getEmail());
    }
}
