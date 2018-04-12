package com.siwoo.webappag1;

import com.siwoo.webappag1.domain.Category;
import com.siwoo.webappag1.domain.WebPage;
import com.siwoo.webappag1.repository.WebPageRepository;
import com.siwoo.webappag1.support.FixtureFactory;
import com.siwoo.webappag1.support.QueryTester;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@SpringBootApplication
public class WebappAg1Application {


	public static void main(String[] args) {
		SpringApplication.run(WebappAg1Application.class, args);

//		QueryTester queryTester = new QueryTester();
//		queryTester.doQuery(s.getBean(EntityManager.class));
	}

}
