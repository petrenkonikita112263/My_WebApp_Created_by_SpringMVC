package ua.spring.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Main class that deals with all Spring Security components required to
 * cover standard requests.
 *
 * @Configuration - this class is Java Configuration.
 * @EnableWebSecurity - important annotation for Spring Security configuration
 */
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Field injection of Datasource object
     */
    @Autowired
    private DataSource securityDataSource;

    /**
     * Overriding the method that puts Spring Security authenticates the user.
     * In this instance, app utilize the jdbc to compare both username and password.
     *
     * @param auth object of AuthenticationManagerBuilder that handles jdbcAuthentication,
     *             and selects username, password and role via selects quires from data store.
     * @throws Exception if something goes bad in jdbcAuthentication method
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource)
                .usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED FROM LAB3PN_USERS WHERE USERNAME = ?")
                .authoritiesByUsernameQuery("SELECT USERNAME, AUTHORITY FROM LAB3PN_USERS WHERE USERNAME = ?");
    }

    /**
     * Overriding method that creates a Servlet Filter, which ensures that the currently
     * logged-in user is associated with the appropriate role. Also sets log in page.
     *
     * @param http the object of HttpSecurity that do all necessary tasks
     * @throws Exception if something goes bad in authorizeRequests method
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/guests").hasAnyRole("GUEST", "CUSTOMER", "ADMIN")
                .antMatchers("/customers/**").hasRole("CUSTOMER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and()
                .formLogin()
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateTheCustomer")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");
    }
}
