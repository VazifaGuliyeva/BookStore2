package com.example.bookstore2.repository;

import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Optional<Student> findUserByEmail(String email);

}
