package com.example.bookstore2.dto.response;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookAllResponse {

    Integer id;

    String bookName;

}
