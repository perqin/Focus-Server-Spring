package com.perqin.focus.spring.web.controllers;

import com.perqin.focus.spring.app.utils.exceptions.ResourcesNotFoundException;
import com.perqin.focus.spring.repository.repositories.UsersRepository;
import com.perqin.focus.spring.repository.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public List<User> findAll() {
        Iterable<User> all = usersRepository.findAll();
        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) throws Exception {
        return usersRepository.findOne(id).orElseThrow(ResourcesNotFoundException::new);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return usersRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        usersRepository.delete(user);
    }
}
