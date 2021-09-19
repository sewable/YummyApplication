package com.yummy.blog.post.form;

import com.yummy.blog.user.entity.UserEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PostForm {

    @NotNull(message = "Post's title is required")
    @NotEmpty(message = "Post's title cannot be empty")
    @Size(max = 100, message = "Title is to long. Max signs are 100")
    private String title;

    @NotNull(message = "Post's photo is required")
    @NotEmpty(message = "Post's photo cannot be empty")
    private String photo;

    @NotNull(message = "Post's ingredients are required")
    @NotEmpty(message = "Post's ingredients cannot be empty")
    private List<String> ingredients;

    @NotNull(message = "Post's content is required")
    @NotEmpty(message = "Post's content cannot be empty")
    private String content;

    @NotNull(message = "Author is required")
    @NotEmpty(message = "Author cannot be empty")
    private UserEntity author;

    public String getTitle() {
        return title;
    }

    public String getPhoto() {
        return photo;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getContent() {
        return content;
    }

    public PostForm setContent(String content) {
        this.content = content;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }
}
