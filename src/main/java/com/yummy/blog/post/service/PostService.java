package com.yummy.blog.post.service;

import com.yummy.blog.photo.entity.PhotoEntity;
import com.yummy.blog.photo.service.PhotoService;
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
    @Autowired
    private PhotoService photoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    public List<PostDto> getPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return PostMapper.map(posts);
    }

    public PostDto getPost(Long id) {
        PostEntity post = postRepository.findOneById(id);
        return PostMapper.map(post);
    }

    public PostDto create(PostForm form, Principal principal) {
        if (principal == null) {
            LOGGER.error("Person who was not logged in tried to create post");
            return null;
        }

        PhotoEntity photo = photoService.store(form.getPhoto());

        PostEntity post = new PostEntity()
                .setTitle(form.getTitle())
                .setPhoto(photo)
                .setContent(form.getContent());

        post.setIngredients(createIngredients(form, post));

        UserEntity user = userRepository.findOneByUsername(principal.getName());

        post.setAuthor(user);

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
