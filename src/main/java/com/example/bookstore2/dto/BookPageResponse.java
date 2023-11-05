package com.example.bookstore2.dto;

import java.util.List;

public record BookPageResponse(
        List<BookDto> authors,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
