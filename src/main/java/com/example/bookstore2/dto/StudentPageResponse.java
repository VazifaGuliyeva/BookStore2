package com.example.bookstore2.dto;

import java.util.List;

public record StudentPageResponse(
        List<StudentDto> authors,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
