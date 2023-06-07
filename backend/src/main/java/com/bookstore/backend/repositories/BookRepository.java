package com.bookstore.backend.repositories;

import com.bookstore.backend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
    boolean existsByName(String name);
}
