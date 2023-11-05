package com.example.bookstore2.mapper;

import com.example.bookstore2.dto.AuthorDto;
import com.example.bookstore2.dto.RegisterRequest;
import com.example.bookstore2.entity.Author;
import com.example.bookstore2.security.AuthorDetails;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
@Service
public interface AuthorMapper {

    AuthorDto toAuthorDto(Author author);

    Author toAuthorDto(AuthorDto authorDto);
    AuthorDetails toAutherDetails(Author author);

    Author toUserFromRegisterRequest(RegisterRequest request);
}
