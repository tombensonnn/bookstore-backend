package com.bookstore.backend.business.abstracts;

import com.bookstore.backend.business.requests.book.CreateBookRequest;
import com.bookstore.backend.business.requests.book.UpdateBookRequest;
import com.bookstore.backend.business.responses.book.GetAllBooksResponse;
import com.bookstore.backend.business.responses.book.GetByIdBookResponse;

import java.util.List;
import java.util.UUID;

public interface BookService {
    List<GetAllBooksResponse> getAll();
    GetByIdBookResponse getById(UUID id);
    void createBook(CreateBookRequest createBookRequest);
    void updateBook(UpdateBookRequest updateBookRequest);
}
