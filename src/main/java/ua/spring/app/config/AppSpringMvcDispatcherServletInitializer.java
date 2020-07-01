package ua.spring.app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * This class initialize the application in Servlet container environment.
 */
public class AppSpringMvcDispatcherServletInitializer
        extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Overriding the method that sets parent class - application context configuration.
     *
     * @return return the array of root config classes
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * Overriding the method that sets the main Servlet config class.
     *
     * @return the array of servlets classes
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    /**
     * Overriding the method that sets DispatcherServlet mapping pattern.
     *
     * @return the array of strings value of DS patterns
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
