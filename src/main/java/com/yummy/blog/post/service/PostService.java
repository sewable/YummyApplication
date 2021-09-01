package com.yummy.blog.post.service;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.IngredientEntity;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.post.form.PostForm;
import com.yummy.blog.post.mapper.PostMapper;
import com.yummy.blog.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDto> getPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return PostMapper.map(posts);
    }

    public PostDto getPost(Long id) {
        PostEntity post = postRepository.findOneById(id);
        return PostMapper.map(post);
    }

    public PostDto getPostByTitle(String title) {
        PostEntity post = postRepository.findOneByTitle(title);
        return PostMapper.map(post);
    }

    public PostDto getPostByAuthor(String author) {
        PostEntity post = postRepository.findOneByAuthor(author);
        return PostMapper.map(post);
    }

    public PostDto create(PostForm form) {
        PostEntity post = new PostEntity()
                .setTitle(form.getTitle())
                .setPhoto(form.getPhoto())
                .setContent(form.getContent())
                .setAuthor(form.getAuthor());

        post.setIngredients(createIngredients(form, post));

        return PostMapper.map(
                postRepository.saveAndFlush(post)
        );
    }

    public PostDto update(PostEntity entity) {
        PostEntity post = postRepository.saveAndFlush(entity);
        return PostMapper.map(post);
    }

    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    public List<IngredientEntity> createIngredients(PostForm form, PostEntity entity) {
        return form.getIngredients()
                .stream()
                .map(ingredientStr -> new IngredientEntity().setValue(ingredientStr).setPost(entity))
                .collect(Collectors.toList());
    }
}
