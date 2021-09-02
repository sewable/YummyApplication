package com.yummy.blog.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingredients")
@JsonIgnoreProperties("post")
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;
    private String value;

    public PostEntity getPost() {
        return post;
    }

    public IngredientEntity setPost(PostEntity post) {
        this.post = post;
        return this;
    }

    public String getValue() {
        return value;
    }

    public IngredientEntity setValue(String ingredients) {
        this.value = ingredients;
        return this;
    }
}
