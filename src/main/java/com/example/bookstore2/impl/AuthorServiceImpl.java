package com.example.bookstore2.impl;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.dto.AuthorDtoManager;
import com.example.bookstore2.dto.AuthorPageResponse;
import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.dto.request.AuthorRequest;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.mapper.AuthorMapper;
import com.example.bookstore2.repository.AuthorRepository;
import com.example.bookstore2.security.JwtService;
import com.example.bookstore2.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorDtoManager authorDtoManager;

    private final AuthorMapper authorMapper;
    private final PasswordEncoder encoder;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    @Override
    public AuthorPageResponse getAll(int page,int count) {

        Page<Author> authorPage=authorRepository.findAll(PageRequest.of(page,count));

        return new AuthorPageResponse(
                authorPage.getContent().stream().map(authorMapper::toAuthorDto).toList(),
                authorPage.getTotalElements(),
                authorPage.getTotalPages(),
                authorPage.hasNext()
        );
    }

    @Override
    public Author getById(int id) {

        return authorRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        authorRepository.deleteById(id);

    }

    @Override
    public void add(AuthorRequest request) {
        Author author = Author.builder()
                .authorName(request.authorName())
                .birthDate(request.birthDate())
                .email(request.email())
                .password(request.password())
                .build();

        authorRepository.save(author);
    }

    @Override
    public Author getAuthorbyEmail(String email) {
        return null;
    }

    @Override
    public void register(RegisterRequest request) {
        Author author = authorMapper.toUserFromRegisterRequest(request);
        author.setPassword(encoder.encode(request.password()));
        authorRepository.save(author);
    }

    @Override
    public String login(RegisterRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        UserDetails user = authorMapper.toAutherDetails(getAuthorbyEmail(request.email()));

        return jwtService.generateToken(user);
    }
}
