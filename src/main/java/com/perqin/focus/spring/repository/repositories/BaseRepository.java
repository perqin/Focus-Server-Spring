package com.perqin.focus.spring.repository.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T save(T persisted);

    List<T> findAll();

    Optional<T> findOne(ID id);

    void delete(T deleted);
}
