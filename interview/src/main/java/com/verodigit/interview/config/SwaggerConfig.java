package com.verodigit.interview.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@OpenAPIDefinition(security = { @SecurityRequirement(name = "basic") })
@SecurityScheme( type = SecuritySchemeType.HTTP, name = "basic", scheme = "basic")
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public OpenAPI customOpenAPI() {

        License mitLicense = new License().name("veroDigit").url("https://www.google.com");

        Info info = new Info()
                .title("ArtWork Web-Service")
                .description("this is application.properties artwork swagger page for easier access to endpoint")
                .license(mitLicense)
                .version("0.1");
        return new OpenAPI().info(info);
    }
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addRedirectViewController("/swagger-ui", "/swagger-ui/index.html");
        registry.addRedirectViewController("/swagger-ui.html", "/swagger-ui/index.html");
    }

}