package com.translator.xtm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class XtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtmApplication.class, args);
	}

}
