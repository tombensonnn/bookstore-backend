package com.bookstore.backend.business.responses.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBooksResponse {
    private String id;
    private String name;
    private String authorId;
}
