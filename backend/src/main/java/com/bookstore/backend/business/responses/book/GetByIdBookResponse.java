package com.bookstore.backend.business.responses.book;

import com.bookstore.backend.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBookResponse {
    private String id;
    private String name;
    private Author author;
}
