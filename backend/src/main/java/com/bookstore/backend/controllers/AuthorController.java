package com.bookstore.backend.controllers;

import com.bookstore.backend.dto.requests.author.DeleteAuthorRequest;
import com.bookstore.backend.dto.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.services.AuthorService;
import com.bookstore.backend.dto.AuthorDto;
import com.bookstore.backend.dto.requests.author.CreateAuthorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDto> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable String id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AuthorDto create(@RequestBody CreateAuthorRequest createAuthorRequest){
       return this.authorService.createAuthor(createAuthorRequest);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public AuthorDto update(@RequestBody UpdateAuthorRequest updateAuthorRequest){
       return this.authorService.updateAuthor(updateAuthorRequest);
    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public AuthorDto delete(@RequestBody DeleteAuthorRequest deleteAuthorRequest) {
        return this.authorService.deleteAuthor(deleteAuthorRequest);
    }

}
