package com.perqin.focus.spring.app.config;

import com.perqin.focus.spring.service.ServicesScanned;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServicesScanned.class)
public class ServicesConfig {
}
