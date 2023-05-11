package com.brewnotion.blog.payloads;

import com.brewnotion.blog.entities.Category;
import com.brewnotion.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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
}
