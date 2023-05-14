package com.brewnotion.blog.controllers;

import com.brewnotion.blog.payloads.ApiResponse;
import com.brewnotion.blog.payloads.CommentDto;
import com.brewnotion.blog.services.CommentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @PathVariable Integer postId) {

        CommentDto createdComment = this.commentService.createComment(commentDto, postId);
        return ResponseEntity.ok(createdComment);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId) {

        this.commentService.deleteComment(commentId);
        return ResponseEntity.ok(new ApiResponse("Comment Deleted Successfully!!", true));
    }

}
