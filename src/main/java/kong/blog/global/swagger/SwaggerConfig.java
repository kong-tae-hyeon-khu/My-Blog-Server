package kong.blog.global.swagger;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration

public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("test")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        Info info = new Info().title("제목")
                .description("설명")
                .version("버전");

        // 보안 스킴을 변경합니다. "bearer" 대신 "apiKey"을 사용하고 "Authorization" 대신 "ApiKeyAuth"를 지정합니다.
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER)
                .name("Authorization");

        // 보안 요구사항을 변경합니다.
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("ApiKeyAuth");

        return new OpenAPI().info(info)
                .components(new Components().addSecuritySchemes("ApiKeyAuth", securityScheme))
                .security(Arrays.asList(securityRequirement));
    }



}
