package com.example.bookstore2.dto;

import java.time.LocalDate;

public record StudentDto(
        String authorName,
        LocalDate birthDate,
        String email
) {
}
