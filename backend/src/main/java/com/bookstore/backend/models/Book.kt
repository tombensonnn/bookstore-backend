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
        val name: String?,

        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "author_id")
        val author: Author?
) {
    constructor(name: String, author: Author): this(
        "",
            name = name,
            author = author
    )
}
