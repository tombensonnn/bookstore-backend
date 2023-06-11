package com.bookstore.backend.models

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "books")
data class Book(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id")
        val id: String?,

        @Column(name = "name")
        var name: String?,

        @ManyToOne
        @JoinColumn(name = "author_id", nullable = false)
        val author: Author?
) {
    constructor(name: String, author: Author): this(
            "",
            name = name,
            author = author
    )
}
