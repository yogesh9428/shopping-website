package com.Shopping.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity, be cautious
            .authorizeRequests()
                .requestMatchers("/login", "/customer/registration", "/css/**", "/js/**", "/images/**")
                .permitAll()  // Allow access to login, registration, and static files
                .anyRequest().authenticated()  // All other URLs require authentication
            .and()
            .formLogin()
                .loginPage("/login")  // Specify the login page URL
                .loginProcessingUrl("/login")  // URL for submitting login data
                .defaultSuccessUrl("/home", true)  // After successful login, go to the home page
                .permitAll()  // Allow access to login page for everyone
            .and()
            .logout()
                .logoutUrl("/logout")  // URL for logout
                .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                .permitAll();  // Allow access to logout for everyone

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt password encoder for securing passwords
    }
}
