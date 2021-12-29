package com.security.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        /*BASIC Authentication for any Request*/
        //http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();

        /*Basic Authenticaton for URL Based Security*/
        // http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();

        /*Basic Authentication with Role Based*/
        //http.authorizeRequests().antMatchers("/rest/**").hasRole("ADMIN").and().httpBasic();

        /*Basic Authentication with Multiple Role Based*/
        //http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN","USER").and().httpBasic();

        /*Basic Authentication with Single or Multiple Authority Based*/
        //http.authorizeRequests().antMatchers("/rest/**").hasAuthority("ROLE_ADMIN").and().httpBasic();
        http.authorizeRequests().antMatchers("/rest/**").hasAnyAuthority("ROLE_ADMIN","ROLE_USER").and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Admin")
                .password(encoder().encode("Password"))
                .roles("ADMIN").and()
                .withUser("User")
                .password(encoder().encode("Password"))
                .roles("USER")
                .and().passwordEncoder(encoder());

    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
