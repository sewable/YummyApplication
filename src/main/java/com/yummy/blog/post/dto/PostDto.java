package com.yummy.blog.post.dto;

public class PostDto {

    private Long id;
    private String title;
    private String content;
    private String author;

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

    public String getContent() {
        return content;
    }

    public PostDto setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public PostDto setAuthor(String author) {
        this.author = author;
        return this;
    }
}
