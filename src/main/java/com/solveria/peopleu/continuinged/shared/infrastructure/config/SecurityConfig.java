package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import com.solveria.core.security.filter.JwtTenantHeaderFilter;
import com.solveria.core.security.filter.SecurityContextFilter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
// Sin esto los @PreAuthorize del servicio son DECORATIVOS: Spring no crea el interceptor y ninguna
// capability se comprueba. Va aqui y no en otra clase porque dos configuraciones de method security
// en el mismo contexto se pisan. EndpointsEstanCerradosTest comprueba que todo endpoint lleve la
// anotacion; esta linea es la que hace que la anotacion valga.
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            @Value("${security.jwt.enabled:true}") boolean jwtEnabled,
            CorsConfigurationSource corsConfigurationSource,
            ObjectProvider<JwtDecoder> accessTokenJwtDecoder)
            throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .cors(cors -> cors.configurationSource(corsConfigurationSource))
                .sessionManagement(
                        session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        if (jwtEnabled) {
            http.authorizeHttpRequests(
                            auth ->
                                    auth.requestMatchers(
                                                    "/actuator/health/**",
                                                    "/actuator/info",
                                                    "/v3/api-docs/**",
                                                    "/swagger-ui/**",
                                                    "/swagger-ui.html")
                                            .permitAll()
                                            .anyRequest()
                                            .authenticated())
                    .oauth2ResourceServer(
                            oauth2 ->
                                    oauth2.jwt(
                                            jwt -> {
                                                JwtDecoder decoder =
                                                        accessTokenJwtDecoder.getIfAvailable();
                                                if (decoder != null) {
                                                    jwt.decoder(decoder);
                                                }
                                                jwt.jwtAuthenticationConverter(jwtConverter());
                                            }));
        } else {
            http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());
        }
        if (jwtEnabled) {
            http.addFilterAfter(new JwtTenantHeaderFilter(), AnonymousAuthenticationFilter.class);
            http.addFilterAfter(new SecurityContextFilter(), JwtTenantHeaderFilter.class);
        }
        return http.build();
    }

    /**
     * Las autoridades salen de {@code permissions} (lo que lee tambien el SecurityContextFilter de
     * core-platform), con prefijo {@code SCOPE_}, y los roles de {@code roles} con prefijo {@code
     * ROLE_}. IAM no emite {@code scope}: seria la misma lista dos veces en cada peticion.
     */
    private JwtAuthenticationConverter jwtConverter() {
        JwtGrantedAuthoritiesConverter scopes = new JwtGrantedAuthoritiesConverter();
        scopes.setAuthoritiesClaimName("permissions");
        scopes.setAuthorityPrefix("SCOPE_");
        JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(
                jwt -> {
                    Set<GrantedAuthority> authorities = new HashSet<>(scopes.convert(jwt));
                    Object roles = jwt.getClaims().get("roles");
                    if (roles instanceof Collection<?> values) {
                        values.stream()
                                .map(SecurityConfig::roleAuthority)
                                .forEach(authorities::add);
                    } else if (roles instanceof String text && !text.isBlank()) {
                        Arrays.stream(text.split("[\\s,]+"))
                                .map(SecurityConfig::roleAuthority)
                                .forEach(authorities::add);
                    }
                    return authorities;
                });
        return converter;
    }

    private static GrantedAuthority roleAuthority(Object value) {
        String role = value == null ? "" : value.toString().trim().toUpperCase(Locale.ROOT);
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        return new SimpleGrantedAuthority(role);
    }

    /**
     * El frontend (Next.js, otro origen) habla con este servicio directo desde el navegador: sin
     * esto Spring Security no agrega cabeceras CORS y el navegador bloquea todo antes de que llegue
     * a ningun controller. Localhost por defecto; en otro entorno se pasa la lista por {@code
     * PU_CONTINUING_EDUCATION_CORS_ALLOWED_ORIGINS}.
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource(
            @Value(
                            "${peopleu.cors.allowed-origins:http://localhost:3000,http://127.0.0.1:3000,"
                                    + "http://localhost:3001,http://127.0.0.1:3001}")
                    List<String> allowedOrigins) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(allowedOrigins);
        configuration.setAllowedMethods(
                List.of("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setExposedHeaders(List.of("X-Correlation-Id"));
        configuration.setAllowCredentials(false);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
