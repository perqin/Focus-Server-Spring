package com.perqin.focus.spring.domain.repositories;

import com.perqin.focus.spring.domain.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<User, Long> {
}
