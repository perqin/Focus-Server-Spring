package com.perqin.focus.spring.app.initializers;

import com.perqin.focus.spring.app.config.*;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                SecurityConfig.class,
                ApiServletConfig.class,
                PersistenceJpaConfig.class,
                LogbackConfig.class,
                ServicesConfig.class
        };
    }

    @Override
    protected String getServletName() {
        return "api";
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/api/*"
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
}
