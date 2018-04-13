package com.siwoo.webappag1;

import com.siwoo.webappag1.support.QueryTester;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import java.util.Locale;

@Slf4j
@SpringBootApplication
public class WebappAg1Application {


	public static void main(String[] args) {
		ApplicationContext s = SpringApplication.run(WebappAg1Application.class, args);

		QueryTester queryTester = new QueryTester();
		queryTester.doQuery(s.getBean(EntityManager.class));
	}

	@Autowired
	MessageSource messageSource;
	@Bean
	CommandLineRunner test() {
		return args -> {
			log.warn(messageSource.getMessage("home.greeting",null, Locale.getDefault()));
		};
	}

}
