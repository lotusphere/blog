package com.lotusphere.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CommentDto {
    private long id;

    @NotEmpty(message = "Name may not be empty")
    private String name;

    @Email
    private String email;

    @NotEmpty(message = "Body may not be empty")
    private String body;

    // TODO: difference between @NotEmpty, @NotBlank, @NotNull
}
