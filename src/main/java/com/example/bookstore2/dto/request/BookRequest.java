package com.example.bookstore2.dto.request;


public record BookRequest(
        String bookName,
        Integer authorId
) {
}
