package com.perqin.focus.spring.web.initializers;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.perqin.focus.spring.config.ApiServletConfig;
import com.perqin.focus.spring.config.LogbackConfig;
import com.perqin.focus.spring.config.PersistenceJpaConfig;
import com.perqin.focus.spring.config.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Add Logback config before ContextLoaderListener
        servletContext.addListener(LogbackConfigListener.class);
        servletContext.setInitParameter("logbackConfigLocation", "/WEB-INF/logback-spring.xml");

        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

        applicationContext.register(SecurityConfig.class);
        applicationContext.register(ApiServletConfig.class);
        applicationContext.register(PersistenceJpaConfig.class);
        applicationContext.register(LogbackConfig.class);

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        ServletRegistration.Dynamic api = servletContext.addServlet("api", new DispatcherServlet(dispatcherContext));
        api.setLoadOnStartup(1);
        api.addMapping("/api/*");
    }
}
