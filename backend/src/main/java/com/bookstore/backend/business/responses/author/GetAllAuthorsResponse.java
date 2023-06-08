package com.bookstore.backend.business.responses.author;

import com.bookstore.backend.entities.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAuthorsResponse {
    private String id;
    private String name;
    private Set<Book> books;
}
