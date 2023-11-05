package com.example.bookstore2.repository;

import com.example.bookstore2.entity.StudentReadingBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentReadingBookRepository extends JpaRepository<StudentReadingBook,Integer> {
}
