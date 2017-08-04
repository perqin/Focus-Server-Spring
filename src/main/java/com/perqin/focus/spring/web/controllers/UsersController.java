package com.perqin.focus.spring.web.controllers;

import com.perqin.focus.spring.domain.entities.User;
import com.perqin.focus.spring.domain.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersRepository usersRepository;

//    public UsersController(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }

    @GetMapping
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user = new User();
//        user.setId(0);
//        user.setUsername("perqin");
//        user.setPassword("pass");
//        users.add(user);
        return users;
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") long id) {
        return null;
    }

    @PostMapping
    public long createUser(@RequestBody User user) {
        return 0;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
    }
}
