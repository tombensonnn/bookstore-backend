package com.bookstore.backend.repositories;

import com.bookstore.backend.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
    boolean existsByName(String name);
}
