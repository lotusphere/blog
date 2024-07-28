package com.lotusphere.blog.service;

import com.lotusphere.blog.payload.CommentDto;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    // TODO: Long or long?
    CommentDto getCommentById(Long postId, Long id);

    CommentDto updateComment(Long postId, long id, CommentDto commentDto);

    void deleteComment(Long postId, Long id);
}
