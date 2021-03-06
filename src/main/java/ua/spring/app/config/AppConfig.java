package ua.spring.app.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Main configuration class for this app.
 *
 * @Configuration - this class is Java Configuration.
 * @EnableWebMvc - app uses MVC.
 * @ComponentScan - looks for the components in app.
 * @PropertySource - externalizes the configuration to a property file.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.spring.app")
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {

    /**
     * Constant for this class that add logging functionality.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    private final Environment env;

    /**
     * Inject the environment field in order to obtain the property.
     */
    public AppConfig(Environment env) {
        this.env = env;
    }

    /**
     * Annotation indicates the bean initialization that gonna created by DI.
     * This method sets View Resolver - where pages are store and theirs format.
     *
     * @return get the object of view resolver
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * Annotation indicates the bean initialization that gonna created by DI.
     * This method gets the datasource object from connection that's created
     * using data info (JDBC) from property file.
     *
     * @return get the object of datasource
     */
    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
        try {
            securityDataSource.setDriverClass(env.getProperty("ORACLE_DB_DRIVER_CLASS"));
        } catch (PropertyVetoException e) {
            LOGGER.error("Can't set driver from properties file", e);
        }
        LOGGER.info(">>> oracle driver = " + env.getProperty("ORACLE_DB_DRIVER_CLASS"));
        securityDataSource.setJdbcUrl(env.getProperty("ORACLE_DB_URL"));
        securityDataSource.setUser(env.getProperty("ORACLE_DB_USERNAME"));
        securityDataSource.setPassword(env.getProperty("ORACLE_DB_PASSWORD"));
        securityDataSource.setInitialPoolSize(getIntProperty("initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("maxIdleTime"));
        return securityDataSource;
    }

    /**
     * Helpful method that parse String value to Int.
     *
     * @return return int value
     */
    private int getIntProperty(String propertyName) {
        String propertyValue = env.getProperty(propertyName);
        return Integer.parseInt(propertyValue);
    }

    /**
     * Implementing methods from WebMvcConfigurer interface.
     * Method sets up the bootstrap files or additional css|js files and
     * registers them as static resource handles.
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/resources/bootstrap/");
    }

}
