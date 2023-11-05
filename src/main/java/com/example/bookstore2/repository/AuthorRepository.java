package com.example.bookstore2.repository;

import com.example.bookstore2.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    Optional<Author> findUserByEmail(String email);

}
