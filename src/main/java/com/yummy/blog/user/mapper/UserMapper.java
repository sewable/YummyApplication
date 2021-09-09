package com.yummy.blog.user.mapper;

import com.yummy.blog.post.mapper.PostMapper;
import com.yummy.blog.user.dto.UserDto;
import com.yummy.blog.user.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto map(UserEntity entity) {
        return new UserDto()
                .setUsername(entity.getUsername())
                .setPassword(entity.getPassword())
                .setRole(entity.getRole());
    }

    public static List<UserDto> map(List<UserEntity> entities) {
        return entities
                .stream()
                .map(UserMapper::map)
                .collect(Collectors.toList());
    }
}
