package com.lotusphere.blog.service.impl;

import com.lotusphere.blog.entity.Post;
import com.lotusphere.blog.payload.PostDto;
import com.lotusphere.blog.repository.PostRepository;
import com.lotusphere.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    // TODO: final
    private PostRepository postRepository;

    // @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        // convert DTO to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

        // convert entity to DTO
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    @Override
    public List<PostDto> getAllPosts() {
        return null;
    }

    // convert Entity to Dto
    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    // convert Dto to Entity
    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle((postDto.getTitle()));
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

}
