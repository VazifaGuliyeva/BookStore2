package com.example.bookstore2.security;

import com.example.bookstore2.mapper.AuthorMapper;
import com.example.bookstore2.mapper.StudentMapper;
import com.example.bookstore2.repository.AuthorRepository;
import com.example.bookstore2.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return studentMapper.toStudentDetails(studentRepository.findUserByEmail(username).get());
    }
}
