package com.lotusphere.blog.service.impl;

import com.lotusphere.blog.entity.Post;
import com.lotusphere.blog.exception.ResourceNotFoundException;
import com.lotusphere.blog.payload.PostDto;
import com.lotusphere.blog.payload.PostResponse;
import com.lotusphere.blog.repository.PostRepository;
import com.lotusphere.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

//    @Override
//    public List<PostDto> getAllPosts() {
//        List<Post> posts = postRepository.findAll();
//        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
//    }

//    @Override
//    public List<PostDto> getAllPosts(int pageNumber, int pageSize) {
//        // create Pageable instance
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        Page<Post> posts = postRepository.findAll(pageable);
//
//        // get content for page object
//        List<Post> postList = posts.getContent();
//        return postList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
//    }

    // TODO: Lambda can be replaced with method reference
    @Override
    public PostResponse getAllPosts(int pageNumber, int pageSize) {
        // create Pageable instance
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Post> posts = postRepository.findAll(pageable);

        // get content for page object
        List<Post> postList = posts.getContent();
        List<PostDto> content = postList.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNumber(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        // get post by id from the database
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        postRepository.deleteById(id);
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
