package com.yummy.blog.post.dto;

import com.yummy.blog.photo.dto.PhotoDto;
import com.yummy.blog.user.dto.UserDto;

import java.util.List;

public class PostDto {

    private Long id;
    private String title;
    private PhotoDto photo;
    private List<String> ingredients;
    private String content;
    private UserDto author;

    public Long getId() {
        return id;
    }

    public PostDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public PhotoDto getPhoto() {
        return photo;
    }

    public PostDto setPhoto(PhotoDto photo) {
        this.photo = photo;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public PostDto setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDto setContent(String content) {
        this.content = content;
        return this;
    }

    public UserDto getAuthor() {
        return author;
    }

    public PostDto setAuthor(UserDto author) {
        this.author = author;
        return this;
    }
}
