package com.bookstore.backend.dataAccess.abstracts;

import com.bookstore.backend.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
