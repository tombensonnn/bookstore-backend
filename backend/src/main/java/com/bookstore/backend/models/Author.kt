package com.bookstore.backend.models

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator

@Entity
@Table(name = "authors")
data class Author(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(name = "id")
        val id: String? = "",

        @Column(name = "name")
        var name: String?,

        @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        @Column(name = "books")
        val books: Set<Book>? = HashSet()
) {
        constructor(name: String?): this(
                "",
                name = name,
        )
}
