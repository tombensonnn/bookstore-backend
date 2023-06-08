package com.bookstore.backend.controllers;

import com.bookstore.backend.business.requests.book.CreateBookRequest;
import com.bookstore.backend.business.requests.book.UpdateBookRequest;
import com.bookstore.backend.business.responses.book.GetAllBooksResponse;
import com.bookstore.backend.business.responses.book.GetByIdBookResponse;
import com.bookstore.backend.business.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<GetAllBooksResponse> getAll() {
        return this.bookService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBookResponse getById(@PathVariable String id) {
        return this.bookService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CreateBookRequest createBookRequest) {
        this.bookService.createBook(createBookRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBookRequest updateBookRequest) {
        this.bookService.updateBook(updateBookRequest);
    }

}
