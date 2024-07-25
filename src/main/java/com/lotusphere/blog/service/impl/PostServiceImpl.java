package com.lotusphere.blog.service.impl;

import com.lotusphere.blog.entity.Post;
import com.lotusphere.blog.exception.ResourceNotFoundException;
import com.lotusphere.blog.payload.PostDto;
import com.lotusphere.blog.repository.PostRepository;
import com.lotusphere.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        // TODO: Local variable 'postResponse' is redundant
        // convert entity to DTO
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    // TODO: Lambda can be replaced with method reference
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
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
