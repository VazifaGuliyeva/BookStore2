package com.example.bookstore2.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "students")
@Data

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "student_name")
    String studentName;

    @Column(name = "birth_date")
    LocalDate birthDate;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @OneToMany(mappedBy = "student")
    List<Subscription> subscriptions;

    @ManyToMany
    @JoinTable(name = "student_reading_books",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books;

}
