package com.lotusphere.blog.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class PostDto {
    private long id;

    @NotBlank
    @Size(min = 1, message = "Post title should have at least 1 characters")
    private String title;

    @NotBlank
    @Size(min = 1, message = "Post message should have at least 1 characters")
    private String description;

    @NotBlank
    @Size(min = 1, message = "Post content should have at least 1 characters")
    private String content;

    private Set<CommentDto> comments;
}
