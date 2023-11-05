package com.example.bookstore2.dto.request;


import jakarta.persistence.Column;

import java.time.LocalDate;

public record AuthorRequest(
        String authorName,
        LocalDate birthDate,
        String email,
        String password

) {
}
