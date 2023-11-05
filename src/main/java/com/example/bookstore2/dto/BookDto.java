package com.example.bookstore2.dto;

import com.example.bookstore2.entity.Author;

public record BookDto(
        String bookName,
        Author author
) {
}
