package com.yummy.blog.photo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "photo")
public class PhotoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(name = "original_name")
    private String originalName;

    @Column(name = "content_type")
    private String contentType;

    public PhotoEntity() {
    }

    public PhotoEntity(String name, String originalName, String contentType) {
        this.name = name;
        this.originalName = originalName;
        this.contentType = contentType;
    }

    public Long getId() {
        return id;
    }

    public PhotoEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PhotoEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getOriginalName() {
        return originalName;
    }

    public PhotoEntity setOriginalName(String originalName) {
        this.originalName = originalName;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public PhotoEntity setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }
}
