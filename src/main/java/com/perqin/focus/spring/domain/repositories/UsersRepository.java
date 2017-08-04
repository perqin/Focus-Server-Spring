package com.perqin.focus.spring.domain.repositories;

import com.perqin.focus.spring.domain.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<User, Long> {
}
