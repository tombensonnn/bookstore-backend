package com.bookstore.backend.business.requests.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAuthorRequest {
    private UUID id;

    @NotNull(message = "Name field cannot be null")
    @NotBlank
    @Size(min = 5)
    private String name;
}
