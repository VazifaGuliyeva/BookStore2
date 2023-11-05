package com.example.bookstore2.dto;

import java.util.List;

public record AuthorPageResponse(
        List<AuthorDto> authors,
        long totalElements,
        int totalPages,
        boolean hasNextPage
) {
}
