package com.example.bshop42.security;

import com.example.bshop42.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    static final String[] PERMIT = {"/static/**", "/sign-up", "/sign-in"};

    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(PERMIT).permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                        .anyRequest().permitAll()
                )
                .formLogin(form ->
                        form
                                .loginPage("/sign-in")
                                .defaultSuccessUrl("/main")
                                .failureUrl("/sign-in?error=true")
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/sign-in?logout=true")
                        .deleteCookies("JSESSIONID")
                        .permitAll())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(authService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
}
