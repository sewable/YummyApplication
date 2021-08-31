package com.yummy.blog.post.service;

import com.yummy.blog.post.dto.PostDto;
import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.post.form.PostForm;
import com.yummy.blog.post.mapper.PostMapper;
import com.yummy.blog.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
                .setContent(form.getContent())
                .setAuthor(form.getAuthor());

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
}
