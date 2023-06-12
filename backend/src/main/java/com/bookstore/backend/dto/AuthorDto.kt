package com.bookstore.backend.dto

data class AuthorDto(
        val id: String?,
        val name: String?,
        val books: Set<AuthorBookDto>
)
