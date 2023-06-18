package com.course.practicaljava;


import com.course.practicaljava.common.OpenApiConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@SpringBootApplication
public class PracticalJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticalJavaApplication.class, args);
	}

	@Bean
	GroupedOpenApi userApis() {
		return GroupedOpenApi.builder().group("car").pathsToMatch("/**/car/**").build();
	}

	@Bean
	GroupedOpenApi defaultApis() {
		return GroupedOpenApi.builder().group("default").pathsToMatch("/**/default/**").build();
	}
	@Bean
	GroupedOpenApi b2b_management() {
		return GroupedOpenApi.builder()
				.group("b2b_management")
				.addOpenApiCustomizer(openApi -> {
					openApi.info(new Info().title("b2b management").version("1.0")
							.description("test"));
				})
				.pathsToMatch("/**/b2b_management/**")
				.build();
	}

	@Bean
	GroupedOpenApi b2b_server() {
		return GroupedOpenApi.builder()
				.group("b2b_server")
				.addOpenApiCustomizer(customerGlobalHeaderOpenApiCustomizer())



				. pathsToMatch("/**/edi/**")
				.build();
	}

	@Bean
	public OpenApiCustomizer customerGlobalHeaderOpenApiCustomizer() {
		return openApi-> {
			try {
				OpenApiConfig.OpenApiExamples openApiExamples = new OpenApiConfig().customerGlobalHeaderOpenApiCustomizer2();
				openApiExamples.forEach(openApi.getComponents()::addExamples);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

			openApi.info(new Info()
						.title("Electronic Data Interchange - ANSI X.12")
						.version("1.0")
						.description("Electronic Data Interchange (EDI) is the computer-to-computer exchange of business documents in a standard electronic format between business partners.")

				);

//			var a = new OpenApiConfig();
//
//			try {
//				a.customerGlobalHeaderOpenApiCustomizer2();
//			} catch (IOException e) {
//				throw new RuntimeException(e);
//			}
//
//			a.openAPI();
			};


	}
}
