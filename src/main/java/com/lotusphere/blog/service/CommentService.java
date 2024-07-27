package com.lotusphere.blog.service;

import com.lotusphere.blog.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);
}
