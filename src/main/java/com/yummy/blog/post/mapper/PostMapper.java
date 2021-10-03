package com.yummy.blog.post.mapper;

import com.yummy.blog.photo.dto.PhotoDto;
import com.yummy.blog.photo.mapper.PhotoMapper;
import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.user.mapper.UserMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto map(PostEntity entity) {

        PhotoDto photo = PhotoMapper.map(entity.getPhoto());

        return new PostDto()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setPhoto(photo)
                .setIngredients(IngredientMapper.map(entity.getIngredients()))
                .setContent(entity.getContent())
                .setAuthor(UserMapper.map(entity.getAuthor()));
    }

    public static List<PostDto> map(List<PostEntity> entities) {
        return entities
                .stream()
                .map(PostMapper::map)
                .collect(Collectors.toList());
    }
}
