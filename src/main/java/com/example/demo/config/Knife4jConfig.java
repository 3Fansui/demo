package com.example.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API接口文档")
                        .description("API文档描述")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("你的名字")
                                .email("你的邮箱")))
                .externalDocs(new ExternalDocumentation()
                        .description("外部文档")
                        .url("http://example.com"));
    }
}
