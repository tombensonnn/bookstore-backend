package com.bookstore.backend.business.requests.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
    @NotNull(message = "Message field cannot be null")
    @NotBlank
    @Size(min = 2, max = 25)
    private String name;

    @NotNull
    private String authorId;
}
