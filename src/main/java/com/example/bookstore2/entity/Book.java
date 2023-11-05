package com.example.bookstore2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity(name = "books")

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "book_name")
    String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToMany(mappedBy = "books")
    private List<Student> students;

}
