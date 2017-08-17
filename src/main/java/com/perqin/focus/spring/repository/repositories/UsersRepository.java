package com.perqin.focus.spring.repository.repositories;

import com.perqin.focus.spring.repository.entities.User;

import java.util.Optional;

public interface UsersRepository extends BaseRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
