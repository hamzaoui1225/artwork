package com.verodigit.interview.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${service.username}")
    String username;
    @Value("${service.password}")
    String password;

    /**
     *
     * This Bean is application.properties configuration security for path:
     * - protected paths with authentication
     * - unprotected paths like swagger for visualisation of endpoints
     * also it define the method of authentication
     * - httpBasic is default way of authentication, and it's help developers
     * accessing swagger from web browser (pops up application.properties simple login form)
     *
     */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(Customizer.withDefaults()).csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/v3/api-docs/**",
                                "/swagger-ui/**", "/swagger-ui.html", "/swagger-ui",
                                "/api-docs/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /**
        This bean is for declare users with theirs roles
     **/

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername(username)
                        .username(username)
                        .password("{noop}" + password)
                        // {noop} for bypass encoding faze else it throws IllegalArgumentException
                        // For Production env
                        // TODO Implement an encoding method like BCryptPasswordEncoder
                        .roles("USER")
                        .build()
        );
    }

}