package com.bookstore.backend.business.rules;

import com.bookstore.backend.core.utilities.exceptions.BusinessException;
import com.bookstore.backend.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorBusinessRules {
    private AuthorRepository authorRepository;

    public void checkIfLanguageNameExists(String name) {
        if(this.authorRepository.existsByName(name)) {
            throw new BusinessException("Author already exists");
        }
    }
}
