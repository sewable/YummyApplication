package com.yummy.blog.post.repository;

import com.yummy.blog.post.entity.PostEntity;
import com.yummy.blog.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {
    PostEntity findOneById(Long id);
    @Transactional
    void deleteByIdAndAuthor(Long id, UserEntity author);
}
