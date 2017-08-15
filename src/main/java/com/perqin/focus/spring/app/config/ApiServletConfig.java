package com.perqin.focus.spring.app.config;

import com.perqin.focus.spring.web.controllers.ControllersScanned;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = ControllersScanned.class)
public class ApiServletConfig extends WebMvcConfigurerAdapter {
}
