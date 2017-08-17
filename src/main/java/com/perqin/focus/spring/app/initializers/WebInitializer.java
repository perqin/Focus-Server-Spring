package com.perqin.focus.spring.app.initializers;

import ch.qos.logback.ext.spring.web.LogbackConfigListener;
import com.perqin.focus.spring.app.config.ConfigurationsScanned;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Add Logback config before ContextLoaderListener
        servletContext.addListener(LogbackConfigListener.class);
        servletContext.setInitParameter("logbackConfigLocation", "/WEB-INF/logback-spring.xml");

        super.onStartup(servletContext);
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ ConfigurationsScanned.class };
    }

    @Override
    protected String getServletName() {
        return "api";
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{ "/api/*" };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }
}
