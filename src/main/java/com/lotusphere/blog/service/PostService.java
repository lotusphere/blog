package com.lotusphere.blog.service;

import com.lotusphere.blog.payload.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    PostDto updatePost(long id, PostDto postDto);
}
