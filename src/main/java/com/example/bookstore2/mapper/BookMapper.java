package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.BookDto;
import com.example.bookstore2.entity.Book;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
 public interface BookMapper {
    BookDto toBookDto(Book book);

    Book toBookEntity(BookDto bookDto);
}
