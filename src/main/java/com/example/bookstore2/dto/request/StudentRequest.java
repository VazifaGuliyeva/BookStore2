package com.example.bookstore2.dto.request;

import java.time.LocalDate;

public record StudentRequest(
        String studentName,
        LocalDate birthDate,
        String email,
        String password

) {
}
