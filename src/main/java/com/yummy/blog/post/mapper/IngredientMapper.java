package com.yummy.blog.post.mapper;

import com.yummy.blog.post.entity.IngredientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class IngredientMapper {

    public static String map(IngredientEntity ingredient) {
        return ingredient.getValue();
    }

    public static List<String> map(List<IngredientEntity> ingredients) {
        return ingredients
                .stream()
                .map(IngredientMapper::map)
                .collect(Collectors.toList());
    }
}
