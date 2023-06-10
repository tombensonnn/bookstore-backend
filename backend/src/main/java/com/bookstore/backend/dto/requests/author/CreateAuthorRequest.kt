package com.bookstore.backend.dto.requests.author

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class CreateAuthorRequest(
        @field:NotBlank(message = "Name field cannot be empty")
        @field:Min(4, message = "Name field must be minimum 4 characters")
        val name: String?
)
