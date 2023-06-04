package com.bookstore.backend.dataAccess.abstracts;

import com.bookstore.backend.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
