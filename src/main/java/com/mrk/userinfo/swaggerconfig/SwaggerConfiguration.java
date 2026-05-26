package com.mrk.userinfo.swaggerconfig;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	public OpenAPI userinfoSwagger() {
		return new OpenAPI().info(
				new Info().title("Restaurant Microservice API").description("Restaurant Service APIs Documentation")
						.version("1.0").contact(new Contact().name("MRK").email("mrk@gmail.com")));
	}

}
