package com.example.bookstore2.impl;

import com.example.bookstore2.dto.request.BookRequest;
import com.example.bookstore2.dto.response.BookAllResponse;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Book;
import com.example.bookstore2.repository.BookRepository;
import com.example.bookstore2.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<BookAllResponse> getAll() {

        return bookRepository.findAll().stream()
                .map(book -> new BookAllResponse(book.getId(),book.getBookName()))
                .toList();
    }

    @Override
    public Book getById(int id) {

        return bookRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);

    }

    @Override
    public void add(BookRequest request) {
        Author author = Author.builder().id(request.authorId()).build();
        Book book = Book.builder()
                .bookName(request.bookName())
                .author(author)
                .build();

        bookRepository.save(book);
    }
}
