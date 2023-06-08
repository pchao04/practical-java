package com.course.practicaljava.common;


//import org.springdoc.core.GroupedOpenApi;

import com.course.practicaljava.controller.b2b.ManagementController;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import lombok.SneakyThrows;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

//@EnableWebMvc
@Configuration
public class OpenApiConfig  {

    @Bean
    ModelResolver modelResolver(ObjectMapper universalJsonMapper) {
        return new ModelResolver(universalJsonMapper);
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("EDI")
                        .version("0.0.1")
                );

    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer(OpenApiExamples openApiExamples) {
        return openApi -> {
            // add components examples
            openApiExamples.forEach(openApi.getComponents()::addExamples);


        };
    }

    @Bean
    @SneakyThrows(Exception.class)
    public OpenApiExamples openApiExamples(ResourcePatternResolver resourcePatternResolver) {
        Resource[] resourceList = resourcePatternResolver.getResources("classpath:openapi/examples/*");
        return new OpenApiExamples(resourceList);
    }

    static class OpenApiExamples {

        Map<String, Example> exampleMap = new HashMap<>();

        @SneakyThrows(IOException.class)
        OpenApiExamples(Resource[] resources) {
            for (Resource file : resources) {
                String fileName = file.getFilename();
                Example example = new Example();
                example.setSummary(fileName);
                example.setValue(StreamUtils.copyToString(file.getInputStream(), StandardCharsets.UTF_8));
                exampleMap.put(fileName, example);
            }
        }

        void forEach(BiConsumer<String, Example> biConsumer) {
            exampleMap.forEach(biConsumer);
        }

    }


}
