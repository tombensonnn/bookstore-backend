package com.bookstore.backend.controllers;

import com.bookstore.backend.business.abstracts.AuthorService;
import com.bookstore.backend.business.requests.author.CreateAuthorRequest;
import com.bookstore.backend.business.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.business.responses.author.GetAllAuthorsResponse;
import com.bookstore.backend.business.responses.author.GetByIdAuthorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/authors")
@AllArgsConstructor
public class AuthorController {
    private AuthorService authorService;

    @GetMapping
    public List<GetAllAuthorsResponse> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getById(@PathVariable UUID id) {
        return authorService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateAuthorRequest createAuthorRequest){
        this.authorService.createAuthor(createAuthorRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateAuthorRequest updateAuthorRequest){
        this.authorService.updateAuthor(updateAuthorRequest);
    }



}
