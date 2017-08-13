package com.perqin.focus.spring.app.config;

import com.perqin.focus.spring.web.controllers.UsersController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = UsersController.class)
public class ApiServletConfig extends WebMvcConfigurerAdapter {
//    @Bean
//    public UsersController usersController() {
//        return new UsersController();
//    }
}
