package kong.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private static final String[] PERMIT_URL_ARRAY = {
        "/v3/api-docs/**",
        "/swagger-ui/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()


                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // JWT 토큰 방식을 사용할거니까!
                .and()



                .authorizeRequests()
                .antMatchers(PERMIT_URL_ARRAY).permitAll()
                .anyRequest().hasAnyRole("USER", "ADMIN");



        return http.build();
    }

}
