package com.example.sociallogin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final OAuth2UserService oAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.trace("Configuring http filterChain");
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest()
                        .authenticated()
                ).oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(infoEndpoint ->
                                infoEndpoint.userService(oAuth2UserService)));
        return http.build();
    }
}