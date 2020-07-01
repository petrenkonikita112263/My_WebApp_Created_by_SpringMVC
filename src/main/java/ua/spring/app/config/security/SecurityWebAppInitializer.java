package ua.spring.app.config.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * This class configures Spring SecurityFilterChain (magic behind the app) to intercept
 * all the requests. Additional can add @Order(1) annotation to be declared this
 * class as first one.
 */
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

}
