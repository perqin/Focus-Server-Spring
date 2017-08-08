package com.perqin.focus.spring.web.controllers;

import com.perqin.focus.spring.domain.entities.User;
import com.perqin.focus.spring.domain.repositories.UsersRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Environment env;

    @GetMapping
    public List<User> findAll() {
        Log logger = LogFactory.getLog(getClass());
        logger.warn("================");
        logger.warn(env.getActiveProfiles()[0]);
        Iterable<User> all = usersRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return usersRepository.findOne(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return usersRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        usersRepository.delete(id);
    }
}
