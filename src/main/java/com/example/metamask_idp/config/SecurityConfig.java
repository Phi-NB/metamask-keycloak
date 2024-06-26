package com.example.metamask_idp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests
            .requestMatchers("/login", "/auth/metamask").permitAll()
            .anyRequest().authenticated())
        .oauth2Login(oauth2Login -> oauth2Login
            .loginPage("/login")
            .defaultSuccessUrl("/home", true));
    return http.build();
  }

  // Đăng ký OAuth2 client với Keycloak
  @Bean
  public ClientRegistrationRepository clientRegistrationRepository() {
    return new InMemoryClientRegistrationRepository(keycloakClientRegistration());
  }

  private ClientRegistration keycloakClientRegistration() {
    return ClientRegistration.withRegistrationId("keycloak")
        .clientId("metamask-app")
        .clientSecret("a7GyKHHJEwaWCnm7Pe8876fcRvjCMouy")
        .scope("openid", "profile", "email")
        .authorizationUri("https://sso-stg.saworld.io/protocol/openid-connect/auth")
        .tokenUri("https://sso-stg.saworld.io/protocol/openid-connect/token")
        .userInfoUri("https://sso-stg.saworld.io/protocol/openid-connect/userinfo")
        .jwkSetUri("https://sso-stg.saworld.io/protocol/openid-connect/certs")
        .clientName("Keycloak")
        .build();
  }
}
