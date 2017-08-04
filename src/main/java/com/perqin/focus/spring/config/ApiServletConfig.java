package com.perqin.focus.spring.config;

import com.perqin.focus.spring.web.controllers.UsersController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class ApiServletConfig extends WebMvcConfigurerAdapter {
    @Bean
    public UsersController usersController() {
        return new UsersController();
    }
}
