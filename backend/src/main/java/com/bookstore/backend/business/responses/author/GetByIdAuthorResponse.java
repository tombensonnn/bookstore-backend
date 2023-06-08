package com.bookstore.backend.business.responses.author;

import com.bookstore.backend.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdAuthorResponse {
    private String id;
    private String name;
    private Set<Book> books;
}
