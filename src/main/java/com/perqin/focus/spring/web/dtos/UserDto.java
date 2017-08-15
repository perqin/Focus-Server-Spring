package com.perqin.focus.spring.web.dtos;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String email;
}
