package com.example.bookstore2.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String studentIsNotFound) {
        super(studentIsNotFound);
    }
}
