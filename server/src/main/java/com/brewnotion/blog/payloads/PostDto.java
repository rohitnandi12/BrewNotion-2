package com.brewnotion.blog.payloads;

import com.brewnotion.blog.entities.Category;
import com.brewnotion.blog.entities.Comment;
import com.brewnotion.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
public class PostDto {

    private Integer postId;

    private String title;

    private String content;

    private String imageName;

    private Date addedDate;

    private UserDto user;

    private CategoryDto category;

    private Set<CommentDto> comments = new HashSet<>();
}
