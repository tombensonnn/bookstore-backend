package com.bookstore.backend.controllers;

import com.bookstore.backend.business.services.AuthorService;
import com.bookstore.backend.business.requests.author.CreateAuthorRequest;
import com.bookstore.backend.business.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.business.responses.author.GetAllAuthorsResponse;
import com.bookstore.backend.business.responses.author.GetByIdAuthorResponse;
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
    public List<GetAllAuthorsResponse> getAll() {
        return authorService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdAuthorResponse getById(@PathVariable String id) {
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
