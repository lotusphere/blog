package com.lotusphere.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

// TODO: what is the use of @EnableMethodSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    // TODO: final?
    private UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // TODO: lambda can be replaced with method reference
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize) -> authorize
                        // anyRequest().authenticated())
                        .requestMatchers(HttpMethod.GET, "/api/**").permitAll().anyRequest().authenticated())
                        .httpBasic(Customizer.withDefaults());
        return http.build();
        // requestMatchers(HttpMethod.GET, "/api/**") is used to match specific HTTP requests based on the HTTP method (in this case, GET) and the URL pattern (in this case, URLs that start with /api/).
        // permitAll() method indicates that all requests matching the above criteria should be allowed without authentication.
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();
        UserDetails author = User.builder()
                .username("lotusphere")
                .password(passwordEncoder().encode("lotusphere"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(admin, author);
    }
}
