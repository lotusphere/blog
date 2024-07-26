package com.lotusphere.blog.payload;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
