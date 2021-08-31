package com.yummy.blog.post.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PostForm {

    @NotNull(message = "Post's title is required")
    @NotEmpty(message = "Post's title cannot be empty")
    private String title;

    @NotNull(message = "Post's content is required")
    @NotEmpty(message = "Post's content cannot be empty")
    private String content;

    @NotNull(message = "Author is required")
    @NotEmpty(message = "Author cannot be empty")
    private String author;

    public String getTitle() {
        return title;
    }

    public PostForm setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostForm setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PostForm setAuthor(String author) {
        this.author = author;
        return this;
    }
}
