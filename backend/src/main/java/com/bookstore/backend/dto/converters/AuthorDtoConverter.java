package com.bookstore.backend.dto.converters;

import com.bookstore.backend.dto.AuthorDto;
import com.bookstore.backend.dto.BookAuthorDto;
import com.bookstore.backend.models.Author;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthorDtoConverter {

    private final AuthorBookDtoConverter authorBookDtoConverter;

    public AuthorDtoConverter(AuthorBookDtoConverter converter) {
        this.authorBookDtoConverter = converter;
    }

    public BookAuthorDto convertToBookAuthor(Optional<Author> from) {
        return from.map(a -> new BookAuthorDto(a.getId(), a.getName())).orElse(null);
    }

    public AuthorDto convert(Author author) {

        return new AuthorDto(
                author.getId(),
                author.getName(),
                author.getBooks().stream().map(authorBookDtoConverter::convert).collect(Collectors.toSet()));
    };
}