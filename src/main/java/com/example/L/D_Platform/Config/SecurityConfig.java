package com.example.L.D_Platform.Config;

import com.example.L.D_Platform.Service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth

                        // ── Public ──────────────────────────────────────────
                        .requestMatchers("/auth/**").permitAll()

                        // ── Courses (ADMIN only) ─────────────────────────────
                        .requestMatchers("/api/v1/courses/**").hasAuthority("ROLE_ADMIN")

                        // ── Enrollments ──────────────────────────────────────
                        .requestMatchers(HttpMethod.POST, "/api/v1/enrollments").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,  "/api/v1/enrollments/user/**").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .requestMatchers(HttpMethod.PUT,  "/api/v1/enrollments/*/progress").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                        // ── Assignments (ADMIN only) ─────────────────────────
                        .requestMatchers("/api/v1/assignments/**").hasAuthority("ROLE_ADMIN")

                        // ── Submissions ──────────────────────────────────────
                        .requestMatchers(HttpMethod.POST, "/api/v1/submissions").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,  "/api/v1/submissions").hasAuthority("ROLE_ADMIN")

                        // ── Modules ──────────────────────────────────────────
                        .requestMatchers(HttpMethod.POST, "/v1/modules").hasAuthority("ROLE_ADMIN")
                        .requestMatchers(HttpMethod.GET,  "/v1/modules").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")

                        // ── Module Progress (USER only) ──────────────────────
                        .requestMatchers(HttpMethod.POST, "/v1/progress").hasAuthority("ROLE_USER")

                        // ── Certificates (ADMIN only) ────────────────────────
                        .requestMatchers("/v1/certificates/**").hasAuthority("ROLE_ADMIN")

                        // ── Anything else needs login ────────────────────────
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            CustomUserDetailsService customUserDetailsService) {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration ac) throws Exception {
        return ac.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}