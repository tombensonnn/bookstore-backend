package com.bookstore.backend.controllers;

import com.bookstore.backend.dto.BookDto;
import com.bookstore.backend.dto.requests.book.CreateBookRequest;
import com.bookstore.backend.services.BookService;
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
    public List<BookDto> getAll() {
        return this.bookService.getAll();
    }

//    @GetMapping("/{id}")
//    public GetByIdBookResponse getById(@PathVariable String id) {
//        return this.bookService.getById(id);
//    }
//
    @PostMapping
    public void create(@RequestBody CreateBookRequest createBookRequest) {
        this.bookService.createBook(createBookRequest);
    }
//
//    @PutMapping
//    public void update(@RequestBody UpdateBookRequest updateBookRequest) {
//        this.bookService.updateBook(updateBookRequest);
//    }

}
