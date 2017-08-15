package com.perqin.focus.spring.web.controllers;

import com.perqin.focus.spring.app.utils.exceptions.ResourcesNotFoundException;
import com.perqin.focus.spring.repository.entities.User;
import com.perqin.focus.spring.service.UsersCrudService;
import com.perqin.focus.spring.web.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UsersCrudService usersCrudService;

    @Autowired
    public UsersController(UsersCrudService usersCrudService) {
        this.usersCrudService = usersCrudService;
    }

    @GetMapping
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) throws Exception {
        throw new ResourcesNotFoundException();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto user) {
        return usersCrudService.create(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
    }
}
