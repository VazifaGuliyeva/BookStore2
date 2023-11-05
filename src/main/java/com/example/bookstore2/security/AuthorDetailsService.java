package com.example.bookstore2.security;

import com.example.bookstore2.mapper.AuthorMapper;
import com.example.bookstore2.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Primary
public class AuthorDetailsService implements UserDetailsService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return authorMapper.toAutherDetails(authorRepository.findUserByEmail(username).get());
    }
}
