package com.example.bookstore2.dto;

import com.example.bookstore2.entity.Book;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class BookDtoManager implements Function<Book,BookDto> {
    @Override
    public BookDto apply(Book book) {
        return new BookDto(book.getBookName(),book.getAuthor());
    }
}
