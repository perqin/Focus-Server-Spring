package com.perqin.focus.spring.service;

import com.perqin.focus.spring.web.dtos.UserDto;

public interface UsersCrudService {
    UserDto create(UserDto user);
}
