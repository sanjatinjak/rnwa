package com.example.rnwauniversity;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RnwaUniversityApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RnwaUniversityApplication.class);
                app.setDefaultProperties(Collections
                .singletonMap("server.port", "8080"));
                app.run(args);
	}

}
