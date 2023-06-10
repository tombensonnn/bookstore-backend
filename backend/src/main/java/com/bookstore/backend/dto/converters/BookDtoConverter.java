package com.bookstore.backend.dto.converters;

import com.bookstore.backend.dto.BookDto;
import com.bookstore.backend.models.Book;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookDtoConverter {

    private final AuthorDtoConverter authorDtoConverter;

    public BookDtoConverter(AuthorDtoConverter authorDtoConverter) {
        this.authorDtoConverter = authorDtoConverter;
    }

    public BookDto convert(Book book) {
        return new BookDto(book.getId(), book.getName(), authorDtoConverter.convertToBookAuthor(Optional.ofNullable(book.getAuthor())));
    }
}
