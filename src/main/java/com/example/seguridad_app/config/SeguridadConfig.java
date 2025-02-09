package com.example.seguridad_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SeguridadConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/publico").permitAll() // Es la configuración que permite el acceso sin autenticación a la pantalla de /publico
                        .anyRequest().authenticated() // Se indica que todas las otras solicitudes requieren autenticación
                )
                .formLogin((form) -> form // Es un código para habilitar el formulario de login
                        .permitAll()
                ); // Con .PermitAll() se habilita la autenticación básica

        return http.build();
    }
}