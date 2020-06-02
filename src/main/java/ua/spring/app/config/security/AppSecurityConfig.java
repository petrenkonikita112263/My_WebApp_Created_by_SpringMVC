package ua.spring.app.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource)
        .usersByUsernameQuery("SELECT USERNAME, PASSWORD, ENABLED FROM LAB3PN_USERS WHERE USERNAME = ?")
        .authoritiesByUsernameQuery("SELECT USERNAME, AUTHORITY FROM LAB3PN_AUTHORITIES WHERE USERNAME = ?");
    }

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
