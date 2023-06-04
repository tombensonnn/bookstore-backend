package com.bookstore.backend.entities;

import jakarta.persistence.*;

import java.util.Set;


@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "books")
    private Set<Book> books;
}
