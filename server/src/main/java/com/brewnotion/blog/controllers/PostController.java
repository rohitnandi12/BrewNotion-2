package com.brewnotion.blog.controllers;

import com.brewnotion.blog.payloads.ApiResponse;
import com.brewnotion.blog.payloads.PostDto;
import com.brewnotion.blog.payloads.PostResponse;
import com.brewnotion.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
                                              @PathVariable Integer userId, @PathVariable Integer categoryId) {
        PostDto createdPostDto = this.postService.createPost(postDto, userId, categoryId);
        return ResponseEntity.ok(createdPostDto);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(this.postService.getPostByUser(userId));
    }

    @GetMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(this.postService.getPostsByCategory(categoryId));
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = "postId", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir) {
        return ResponseEntity.ok(this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postId) {
        return ResponseEntity.ok(this.postService.getPostById(postId));
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId) {
        this.postService.deletePost(postId);
        return ResponseEntity.ok(new ApiResponse("Post is successfully Deleted !!", true));
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
        return ResponseEntity.ok(this.postService.updatePost(postDto, postId));
    }

    @GetMapping("/posts/search/{keywords}")
    public ResponseEntity<List<PostDto>> searchPosts(@PathVariable String keywords) {
        return ResponseEntity.ok(this.postService.searchPosts(keywords));
    }

    @GetMapping("/posts/searchDesc/{keywords}")
    public ResponseEntity<List<PostDto>> searchPostsByDescription(@PathVariable String keywords) {
        return ResponseEntity.ok(this.postService.searchPostsByDescription(keywords));
    }

}
