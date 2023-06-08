package com.bookstore.backend.business.services;

import com.bookstore.backend.business.requests.author.CreateAuthorRequest;
import com.bookstore.backend.business.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.business.responses.author.GetAllAuthorsResponse;
import com.bookstore.backend.business.responses.author.GetByIdAuthorResponse;
import com.bookstore.backend.business.rules.AuthorBusinessRules;
import com.bookstore.backend.core.utilities.mappers.ModelMapperService;
import com.bookstore.backend.repositories.AuthorRepository;
import com.bookstore.backend.entities.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService  {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    private final ModelMapperService modelMapperService;
    private final AuthorRepository authorRepository;
    private final AuthorBusinessRules authorBusinessRules;

    public AuthorService(AuthorRepository authorRepository, ModelMapperService modelMapperService,  AuthorBusinessRules authorBusinessRules) {

        this.authorRepository = authorRepository;
        this.modelMapperService = modelMapperService;
        this.authorBusinessRules = authorBusinessRules;
    }

    public List<GetAllAuthorsResponse> getAll() {
        List<Author> authors = authorRepository.findAll();

        List<GetAllAuthorsResponse> authorsResponses = authors.stream()
                .map(author -> this.modelMapperService.forResponse().map(author, GetAllAuthorsResponse.class)).collect(Collectors.toList());

        return authorsResponses;

    }

    public GetByIdAuthorResponse getById(String id) {

        Author author = this.authorRepository.findById(id).orElseThrow();

        GetByIdAuthorResponse authorResponse = this.modelMapperService.forResponse().map(author, GetByIdAuthorResponse.class);

        return authorResponse;
    }

    public void createAuthor(CreateAuthorRequest createAuthorRequest) {
        this.authorBusinessRules.checkIfLanguageNameExists(createAuthorRequest.getName());

        Author createdAuthor = this.modelMapperService.forRequest().map(createAuthorRequest, Author.class);

        this.authorRepository.save(createdAuthor);
    }

    public void updateAuthor(UpdateAuthorRequest updateAuthorRequest) {
        Author updatedAuthor = this.modelMapperService.forRequest().map(updateAuthorRequest, Author.class);

        this.authorRepository.save(updatedAuthor);
    }
}
