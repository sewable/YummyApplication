package com.yummy.blog.post.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yummy.blog.user.entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "post")
@JsonIgnoreProperties("user")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String photo;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<IngredientEntity> ingredients;

    @Column(columnDefinition = "LONGTEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_username")
    private UserEntity author;

    public PostEntity() {
    }

    public Long getId() {
        return id;
    }

    public PostEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public PostEntity setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    public List<IngredientEntity> getIngredients() {
        return ingredients;
    }

    public PostEntity setIngredients(List<IngredientEntity> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostEntity setContent(String content) {
        this.content = content;
        return this;
    }

    public UserEntity getAuthor() {
        return author;
    }

    public PostEntity setAuthor(UserEntity author) {
        this.author = author;
        return this;
    }
}
