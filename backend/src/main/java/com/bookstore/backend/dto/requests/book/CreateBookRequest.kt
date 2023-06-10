package com.bookstore.backend.dto.requests.book

data class CreateBookRequest(
        val name: String,
        val authorId: String,
)
