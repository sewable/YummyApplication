package com.yummy.blog.photo.mapper;

import com.yummy.blog.photo.dto.PhotoDto;
import com.yummy.blog.photo.entity.PhotoEntity;

public class PhotoMapper {

    public static PhotoDto map(PhotoEntity entity) {
        return new PhotoDto()
                .setId(entity.getId())
                .setName(entity.getName())
                .setOriginalName(entity.getOriginalName())
                .setContentType(entity.getContentType());
    }
}
