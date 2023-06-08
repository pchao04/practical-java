package com.course.practicaljava;


import com.course.practicaljava.common.OpenApiConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
				.addOpenApiCustomizer(openApi -> {


					openApi.info(new Info()
						.title("Electronic Data Interchange - ANSI X.12")
						.version("1.0")
						.description("Electronic Data Interchange (EDI) is the computer-to-computer exchange of business documents in a standard electronic format between business partners.")

					);
				})


				.pathsToMatch("/**/edi/**")
				.build();
	}
}
