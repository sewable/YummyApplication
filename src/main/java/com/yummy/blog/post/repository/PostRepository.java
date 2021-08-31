package com.yummy.blog.post.repository;

import com.yummy.blog.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {
    PostEntity findOneById(Long id);
    PostEntity findOneByTitle(String title);
    PostEntity findOneByAuthor(String author);
}
