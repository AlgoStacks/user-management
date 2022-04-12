package com.as.usermanagement.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class UserManagementSwaggerConfiguration {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.paths(PathSelectors.ant("/user/*"))
					.apis(RequestHandlerSelectors.basePackage("com.as"))
				.build()
					.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("AlgoStacks User Management Service", 
				"api documentation for user management service", 
				"1.0",
				"Apis", 
				new Contact("AlgoStacks", "https://algostacks.com", "info@algostacks.com"),
				"Api license",
				"license url", 
				Collections.emptyList());
	}
}
