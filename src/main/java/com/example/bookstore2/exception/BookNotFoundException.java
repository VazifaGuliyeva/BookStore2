package com.example.bookstore2.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException(String bookIsNotFound) {
        super(bookIsNotFound);
    }
}
