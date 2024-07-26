package com.lotusphere.blog.controller;

import com.lotusphere.blog.payload.PostDto;
import com.lotusphere.blog.payload.PostResponse;
import com.lotusphere.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    // TODO: final
    private PostService postService;

    // @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // create blog post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<PostDto>> getAllPosts() {
//        return ResponseEntity.ok(postService.getAllPosts());
//    }

//    @GetMapping
//    public ResponseEntity<PostResponse> getAllPosts(
//            @RequestParam(defaultValue = "0", required = false) int pageNumber,
//            @RequestParam(defaultValue = "10", required = false) int pageSize
//    ) {
//        return ResponseEntity.ok(postService.getAllPosts(pageNumber, pageSize));
//    }

    @GetMapping
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "id", required = false) String sortBy,
            @RequestParam(defaultValue = "asc", required = false) String sortDir
    ) {
        return ResponseEntity.ok(postService.getAllPosts(pageNumber, pageSize, sortBy, sortDir));
    }

    // TODO: Long or long?
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "id") long id, @RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.updatePost(id, postDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
        postService.deletePost(id);
        return ResponseEntity.ok("Post entity deleted successfully");
    }
}
