package com.bookstore.backend.business.rules;

import com.bookstore.backend.core.utilities.exceptions.BusinessException;
import com.bookstore.backend.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookBusinessRules {
    private BookRepository bookRepository;

    public void checkIfBookNameExists(String name) {
        if(this.bookRepository.existsByName(name)) {
            throw new BusinessException("Book already exists");
        }
    }
}
