package com.mindtree.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DockerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}

}
