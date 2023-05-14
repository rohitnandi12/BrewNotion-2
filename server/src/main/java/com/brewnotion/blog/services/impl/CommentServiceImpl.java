package com.brewnotion.blog.services.impl;

import com.brewnotion.blog.entities.Comment;
import com.brewnotion.blog.entities.Post;
import com.brewnotion.blog.exceptions.ResourceNotFoundException;
import com.brewnotion.blog.payloads.CommentDto;
import com.brewnotion.blog.repositories.CommentRepo;
import com.brewnotion.blog.repositories.PostRepo;
import com.brewnotion.blog.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "postId", postId));

        Comment comment = dtoTOComment(commentDto);
        comment.setPost(post);

        Comment savedComment = this.commentRepo.save(comment);

        return commentToDto(comment);
    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment comment = this.commentRepo
                .findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "commentId", commentId));

        this.commentRepo.delete(comment);
    }

    private CommentDto commentToDto(Comment comment) {
        return this.modelMapper.map(comment, CommentDto.class);
    }

    private Comment dtoTOComment(CommentDto commentDto) {
        return this.modelMapper.map(commentDto, Comment.class);
    }
}
