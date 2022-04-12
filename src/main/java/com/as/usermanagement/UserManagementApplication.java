package com.as.usermanagement;

import com.as.usermanagement.config.YamlConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//TODO:
//disable spring security auto configuration for now, will enable once we start implementing
//@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
@SpringBootApplication
@Slf4j
public class UserManagementApplication {
	static Logger LOGGER = LoggerFactory.getLogger(UserManagementApplication.class);

	@Autowired
	private YamlConfiguration yamlConfiguration;

	public static void main(String[] args) {
		LOGGER.info("Starting application....");
		SpringApplication.run(UserManagementApplication.class, args);
		log.info("LOG from Lombok");
		LOGGER.info("Started User management service.");
	}
}