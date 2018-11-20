package com.pyramidsystems.oc.intake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IntakeApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IntakeApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<IntakeApplication> applicationClass = IntakeApplication.class;

}
