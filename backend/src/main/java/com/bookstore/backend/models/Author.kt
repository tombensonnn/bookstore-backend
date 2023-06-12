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

        @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = [CascadeType.DETACH])
        val books: Set<Book> = HashSet()
) {
        constructor(name: String?): this(
                "",
                name = name,
        )

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Author

                if (id != other.id) return false
                if (name != other.name) return false
                if (books != other.books) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (name?.hashCode() ?: 0)
                return result
        }
}
