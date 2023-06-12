package com.bookstore.backend.dto.converters;

import com.bookstore.backend.dto.AuthorBookDto;
import com.bookstore.backend.models.Book;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AuthorBookDtoConverter {
    public AuthorBookDto convert(Book book) {
        return new AuthorBookDto(Objects.requireNonNull(book.getId()), book.getName());
    }
}
