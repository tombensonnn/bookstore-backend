package com.bookstore.backend.business.abstracts;

import com.bookstore.backend.business.requests.author.CreateAuthorRequest;
import com.bookstore.backend.business.requests.author.UpdateAuthorRequest;
import com.bookstore.backend.business.responses.author.GetAllAuthorsResponse;
import com.bookstore.backend.business.responses.author.GetByIdAuthorResponse;

import java.util.List;
import java.util.UUID;

public interface AuthorService {
    List<GetAllAuthorsResponse> getAll();
    GetByIdAuthorResponse getById(UUID id);
    void createAuthor(CreateAuthorRequest createAuthorRequest);
    void updateAuthor(UpdateAuthorRequest updateAuthorRequest);
}
