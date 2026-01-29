package tadGestionUsuario.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
        // Configuración central de Spring Security: define rutas públicas, protegidas y
        // validación JWT

        private final JwtAuthenticationConverter jwtAuthenticationConverter;

        // Es

        @Bean
        // Define la cadena de filtros de seguridad de la aplicación
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                // Desactiva CSRF para APIs REST
                                .csrf(AbstractHttpConfigurer::disable)

                                // Define qué endpoints son públicos y cuáles requieren autenticación
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers(HttpMethod.GET, "/hello-1", "/hello-2").permitAll()
                                                .anyRequest().authenticated())

                                // Configura el microservicio como Resource Server utilizando JWT
                                .oauth2ResourceServer(oauth2 -> oauth2
                                                .jwt(jwt -> jwt
                                                                .jwtAuthenticationConverter(
                                                                                jwtAuthenticationConverter)))

                                // Evita la creación de sesiones (autenticación stateless)
                                .sessionManagement(session -> session
                                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

                return http.build();
        }
}
