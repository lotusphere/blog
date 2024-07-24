package com.lotusphere.blog.service;

import com.lotusphere.blog.payload.PostDto;

public interface PostService {

    PostDto createPost(PostDto postDto);
}
