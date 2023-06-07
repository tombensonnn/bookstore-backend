package com.bookstore.backend.business.responses.book;

import com.bookstore.backend.entities.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdBookResponse {
    private UUID id;
    private String name;
    private Author author;
}
