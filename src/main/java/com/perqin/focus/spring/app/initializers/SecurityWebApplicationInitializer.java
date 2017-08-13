package com.perqin.focus.spring.app.initializers;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class will register the springSecurityFilterChain Filter for every URL in the application. As an implementation
 * for {@link org.springframework.web.WebApplicationInitializer}, this class will be detected automatically thus the
 * filter chain will be registered.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
}
