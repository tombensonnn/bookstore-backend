package com.bookstore.backend.controllers;

import com.bookstore.backend.dto.BookDto;
import com.bookstore.backend.dto.requests.book.CreateBookRequest;
import com.bookstore.backend.dto.requests.book.DeleteBookRequest;
import com.bookstore.backend.dto.requests.book.UpdateBookRequest;
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

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable String id) {
        return this.bookService.getBookById(id);
    }

    @PostMapping
    public BookDto create(@RequestBody CreateBookRequest createBookRequest) {
        return this.bookService.createBook(createBookRequest);
    }

    @PutMapping
    public BookDto update(@RequestBody UpdateBookRequest updateBookRequest) {
        return this.bookService.updateBook(updateBookRequest);
    }

    @DeleteMapping
    public BookDto delete(@RequestBody DeleteBookRequest deleteBookRequest) {
        return this.bookService.deleteBook(deleteBookRequest);
    }

}
