package ua.spring.app.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "ua.spring.app")
@PropertySource("classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

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

    private int getIntProperty(String propertyName) {
        String propertyValue = env.getProperty(propertyName);
        int integerPropertyValue = Integer.parseInt(propertyValue);
        return integerPropertyValue;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/WEB-INF/resources/bootstrap/");
    }

}
