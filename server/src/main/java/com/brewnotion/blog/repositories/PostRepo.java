package com.brewnotion.blog.repositories;

import com.brewnotion.blog.entities.Category;
import com.brewnotion.blog.entities.Post;
import com.brewnotion.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);

    List<Post> findByTitleContaining(String title);

    @Query("select p from Post p where p.content like :key")
    List<Post> searchByDescription(@Param("key") String desc);
}
