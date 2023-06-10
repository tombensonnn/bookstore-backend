package com.bookstore.backend.repositories;

import com.bookstore.backend.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
    boolean existsByName(String name);
}