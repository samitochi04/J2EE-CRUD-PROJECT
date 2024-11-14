package com.example.demo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class J2eeCrudProjectApplication {
	public static void main(String[] args) {
		/*SpringApplication.run(WebCrudAppApplication.class, args);*/
		SpringApplication app = new SpringApplication(J2eeCrudProjectApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "5000"));
        app.run(args);
	}


}
