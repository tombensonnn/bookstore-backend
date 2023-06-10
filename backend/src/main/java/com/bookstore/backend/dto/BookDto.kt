package com.bookstore.backend.dto

data class BookDto(
        val id: String?,
        val name: String?,
        val author: BookAuthorDto?
)
