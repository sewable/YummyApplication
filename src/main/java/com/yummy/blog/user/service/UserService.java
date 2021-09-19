package com.yummy.blog.user.service;

import com.yummy.blog.user.dto.UserDto;
import com.yummy.blog.user.entity.UserEntity;
import com.yummy.blog.user.form.UserForm;
import com.yummy.blog.user.mapper.UserMapper;
import com.yummy.blog.user.repository.UserRepository;
import com.yummy.blog.user.role.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return UserMapper.map(users);
    }

    public UserDto getUser(String username) {
        UserEntity user = userRepository.findOneByUsername(username);
        return UserMapper.map(user);
    }

    public UserDto create(UserForm form) {
        UserEntity user = new UserEntity()
                .setUsername(form.getUsername())
                .setPassword(form.getPassword())
                .setRole(UserRole.USER);

        UserEntity entity = userRepository.saveAndFlush(user);

        return UserMapper.map(entity);
    }

    public UserDto update(UserEntity entity) {
        UserEntity user = userRepository.saveAndFlush(entity);
        return UserMapper.map(user);
    }

    public void delete(String username) {
        userRepository.deleteById(username);
    }
}
