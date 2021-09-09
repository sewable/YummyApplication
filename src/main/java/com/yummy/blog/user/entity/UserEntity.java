package com.yummy.blog.user.entity;

import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.user.role.UserRole;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PostEntity> posts;

    public UserEntity() {
    }

    public UserEntity(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public UserEntity setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public UserEntity setPosts(List<PostEntity> posts) {
        this.posts = posts;
        return this;
    }
}
