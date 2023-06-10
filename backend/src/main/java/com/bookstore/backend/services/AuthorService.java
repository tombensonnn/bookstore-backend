package com.bookstore.backend.services;

import com.bookstore.backend.dto.requests.author.DeleteAuthorRequest;
import com.bookstore.backend.dto.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.exceptions.AuthorCouldNotFindException;
import com.bookstore.backend.exceptions.BusinessException;
import com.bookstore.backend.dto.AuthorDto;
import com.bookstore.backend.dto.requests.author.CreateAuthorRequest;
import com.bookstore.backend.dto.converters.AuthorDtoConverter;
import com.bookstore.backend.models.Author;
import com.bookstore.backend.repositories.AuthorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService  {

    private static final Logger logger = LoggerFactory.getLogger(AuthorService.class);
    private final AuthorDtoConverter authorDtoConverter;
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository, AuthorDtoConverter authorDtoConverter) {
        this.authorRepository = authorRepository;
        this.authorDtoConverter = authorDtoConverter;
    }

    public List<AuthorDto> getAll() {
        List<AuthorDto> authors = this.authorRepository.findAll().stream().map(authorDtoConverter::convert).collect(Collectors.toList());

        return authors;
    }

    public Author findAuthorById(String id) {
        return this.authorRepository.findById(id).orElseThrow(() -> new AuthorCouldNotFindException("This author is not exists"));
    }

    public AuthorDto getAuthorById(String id) {
        return this.authorDtoConverter.convert(findAuthorById(id));
    }

    public AuthorDto createAuthor(CreateAuthorRequest createAuthorRequest) {
        Boolean isAuthorExists = this.authorRepository.existsByName(createAuthorRequest.getName());

        if(isAuthorExists) {
            throw new BusinessException("This author is already exists");
        }

        Author author = new Author(createAuthorRequest.getName());

        return this.authorDtoConverter.convert(authorRepository.save(author));
    }

    public AuthorDto updateAuthor(UpdateAuthorRequest updateAuthorRequest) {

        Author author = findAuthorById(updateAuthorRequest.getId());

        author.setName(updateAuthorRequest.getName());

        return this.authorDtoConverter.convert(authorRepository.save(author));
    }

    public AuthorDto deleteAuthor(DeleteAuthorRequest deleteAuthorRequest) {
        AuthorDto returnedAuthor = this.authorDtoConverter.convert(findAuthorById(deleteAuthorRequest.getId()));

        this.authorRepository.deleteById(deleteAuthorRequest.getId());

        return returnedAuthor;
    }

}
