package com.perqin.focus.spring.web.controllers;

import com.perqin.focus.spring.domain.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    @GetMapping
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(0);
        user.setUsername("perqin");
        user.setPassword("pass");
        users.add(user);
        return users;
    }
}
