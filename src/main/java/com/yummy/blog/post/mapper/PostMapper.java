package com.yummy.blog.post.mapper;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.PostEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostDto map(PostEntity entity) {
        return new PostDto()
                .setId(entity.getId())
                .setTitle(entity.getTitle())
                .setPhoto(entity.getPhoto())
                .setIngredients(IngredientMapper.map(entity.getIngredients()))
                .setContent(entity.getContent())
                .setAuthor(entity.getAuthor());
    }

    public static List<PostDto> map(List<PostEntity> entities) {
        return entities
                .stream()
                .map(PostMapper::map)
                .collect(Collectors.toList());
    }
}
