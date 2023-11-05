package com.example.bookstore2.impl;

import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.StudentDto;
import com.example.bookstore2.dto.StudentDtoManager;
import com.example.bookstore2.dto.StudentPageResponse;
import com.example.bookstore2.dto.request.AuthorRequest;
import com.example.bookstore2.dto.request.StudentRequest;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.entity.Student;
import com.example.bookstore2.mapper.StudentMapper;
import com.example.bookstore2.repository.StudentRepository;
import com.example.bookstore2.security.JwtService;
import com.example.bookstore2.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentDtoManager studentDtoManager;
    private final StudentMapper studentMapper;
    private final PasswordEncoder encoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public StudentPageResponse getAll(int page,int count) {

        Page<Student> studentPage=studentRepository.findAll(PageRequest.of(page,count));

        return new StudentPageResponse(
                studentPage.getContent().stream().map(studentMapper::toStudentDto).toList(),
                studentPage.getTotalElements(),
                studentPage.getTotalPages(),
                studentPage.hasNext()
        );
    }

    @Override
    public Student getById(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        studentRepository.deleteById(id);

    }

    @Override
    public void add(StudentRequest request) {
        Student student = Student.builder()
                .studentName(request.studentName())
                .birthDate(request.birthDate())
                .email(request.email())
                .password(request.password())
                .build();

        studentRepository.save(student);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return null;
    }

    @Override
    public void register(RegisterRequest request) {
        Student student = studentMapper.toUserFromRegisterRequest(request);
        student.setPassword(encoder.encode(request.password()));
        studentRepository.save(student);
    }

    @Override
    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UserDetails user = studentMapper.toStudentDetails(getStudentByEmail(request.email()));

        return jwtService.generateToken(user);
    }
}
