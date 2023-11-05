package com.example.bookstore2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "authors")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "author_name")
    String authorName;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @OneToMany(mappedBy = "author")
    List<Subscription> subscriptions;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books;

}
