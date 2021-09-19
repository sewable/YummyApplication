package com.yummy.blog.user.dto;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.user.enums.UserRole;

import java.util.List;

public class UserDto {

    private String username;
    private String password;
    private UserRole role;
    private List<PostDto> posts;

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserRole getRole() {
        return role;
    }

    public UserDto setRole(UserRole role) {
        this.role = role;
        return this;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public UserDto setPosts(List<PostDto> posts) {
        this.posts = posts;
        return this;
    }

    @Override
    public String toString() {
        return username;
    }
}
