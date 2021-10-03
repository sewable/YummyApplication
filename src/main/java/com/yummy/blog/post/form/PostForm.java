package com.yummy.blog.post.form;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class PostForm {

    @NotNull(message = "Post's title is required")
    @NotEmpty(message = "Post's title cannot be empty")
    @Size(max = 100, message = "Title is to long. Max signs are 100")
    private String title;

    private MultipartFile photo;

    @NotNull(message = "Post's ingredients are required")
    @NotEmpty(message = "Post's ingredients cannot be empty")
    private List<String> ingredients;

    @NotNull(message = "Post's content is required")
    @NotEmpty(message = "Post's content cannot be empty")
    private String content;

    public String getTitle() {
        return title;
    }

    public PostForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public PostForm setPhoto(MultipartFile photo) {
        this.photo = photo;
        return this;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public PostForm setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostForm setContent(String content) {
        this.content = content;
        return this;
    }
}
