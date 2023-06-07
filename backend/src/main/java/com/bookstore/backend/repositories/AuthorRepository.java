package com.bookstore.backend.repositories;

import com.bookstore.backend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
    boolean existsByName(String name);
}
