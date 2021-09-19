package com.yummy.blog.post.service;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.IngredientEntity;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.post.form.PostForm;
import com.yummy.blog.post.mapper.PostMapper;
import com.yummy.blog.post.repository.PostRepository;
import com.yummy.blog.user.entity.UserEntity;
import com.yummy.blog.user.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    public List<PostDto> getPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return PostMapper.map(posts);
    }

    public PostDto getPost(Long id) {
        PostEntity post = postRepository.findOneById(id);
        return PostMapper.map(post);
    }

    public PostDto create(PostForm form) {
        PostEntity post = new PostEntity()
                .setTitle(form.getTitle())
                .setPhoto(form.getPhoto())
                .setContent(form.getContent());

        post.setIngredients(createIngredients(form, post));
        post.setAuthor(form.getAuthor());

        return PostMapper.map(
                postRepository.saveAndFlush(post)
        );
    }

    public PostDto update(PostEntity entity) {
        PostEntity post = postRepository.saveAndFlush(entity);
        return PostMapper.map(post);
    }

    public void delete(Long id, Principal principal) {
        if (principal == null) {
            LOGGER.error("Unauthorized person tried to delete post");
            return;
        }
        UserEntity user = userRepository.findOneByUsername(principal.getName());
        if (user.isAdmin()) {
            postRepository.deleteById(id);
        } else {
            postRepository.deleteByIdAndAuthor(id, user);
        }
    }

    public List<IngredientEntity> createIngredients(PostForm form, PostEntity entity) {
        return form.getIngredients()
                .stream()
                .map(ingredientStr -> new IngredientEntity().setValue(ingredientStr).setPost(entity))
                .collect(Collectors.toList());
    }
}
