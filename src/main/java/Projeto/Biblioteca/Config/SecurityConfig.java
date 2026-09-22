package Projeto.Biblioteca.Config;


import Projeto.Biblioteca.Entity.ROLE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET , "/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE , "/**").hasRole(ROLE.Admin.name())
                        .requestMatchers(HttpMethod.POST ,  "/**").hasRole(ROLE.Admin.name())
                        .anyRequest().authenticated()
                )
                .build();
    }

}
