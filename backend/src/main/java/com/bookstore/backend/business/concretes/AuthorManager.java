package com.bookstore.backend.business.concretes;

import com.bookstore.backend.business.abstracts.AuthorService;
import com.bookstore.backend.business.requests.author.CreateAuthorRequest;
import com.bookstore.backend.business.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.business.responses.author.GetAllAuthorsResponse;
import com.bookstore.backend.business.responses.author.GetByIdAuthorResponse;
import com.bookstore.backend.business.rules.AuthorBusinessRules;
import com.bookstore.backend.core.utilities.mappers.ModelMapperService;
import com.bookstore.backend.repositories.AuthorRepository;
import com.bookstore.backend.entities.Author;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AuthorManager implements AuthorService {

    private AuthorRepository authorRepository;
    private ModelMapperService modelMapperService;
    private AuthorBusinessRules authorBusinessRules;

    @Override
    public List<GetAllAuthorsResponse> getAll() {
        List<Author> authors = authorRepository.findAll();

        List<GetAllAuthorsResponse> authorsResponses = authors.stream()
                .map(author -> this.modelMapperService.forResponse()
                        .map(author, GetAllAuthorsResponse.class)).collect(Collectors.toList());

        return authorsResponses;
    }

    @Override
    public GetByIdAuthorResponse getById(UUID id) {

        Author author = this.authorRepository.findById(id).orElseThrow();

        GetByIdAuthorResponse authorResponse = this.modelMapperService.forResponse().map(author, GetByIdAuthorResponse.class);

        return authorResponse;
    }

    @Override
    public void createAuthor(CreateAuthorRequest createAuthorRequest) {
        this.authorBusinessRules.checkIfLanguageNameExists(createAuthorRequest.getName());

        Author createdAuthor = this.modelMapperService.forRequest().map(createAuthorRequest, Author.class);

        this.authorRepository.save(createdAuthor);
    }

    @Override
    public void updateAuthor(UpdateAuthorRequest updateAuthorRequest) {
        Author updatedAuthor = this.modelMapperService.forRequest().map(updateAuthorRequest, Author.class);

        this.authorRepository.save(updatedAuthor);
    }
}
