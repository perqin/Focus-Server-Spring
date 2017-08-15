package com.perqin.focus.spring.service.impl;

import com.perqin.focus.spring.repository.entities.User;
import com.perqin.focus.spring.repository.repositories.UsersRepository;
import com.perqin.focus.spring.service.UsersCrudService;
import com.perqin.focus.spring.web.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UsersCrudServiceImpl implements UsersCrudService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersCrudServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDto create(UserDto user) {
        User userEntity = new User();
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity = usersRepository.save(userEntity);
        user.setId(userEntity.getId());
        user.setPassword(null);
        return user;
    }
}
