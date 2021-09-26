package com.yummy.blog.photo.dto;

public class PhotoDto {

    private Long id;
    private String name;
    private String originalName;
    private String contentType;

    public Long getId() {
        return id;
    }

    public PhotoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PhotoDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public PhotoDto setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public PhotoDto setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
