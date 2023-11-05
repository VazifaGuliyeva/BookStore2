package com.example.bookstore2.exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String authorIsNotFound) {
        super(authorIsNotFound);
    }
}
