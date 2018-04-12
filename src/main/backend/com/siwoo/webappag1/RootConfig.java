package com.siwoo.webappag1;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("com.siwoo.webappag1.domain")
@EnableJpaRepositories("com.siwoo.webappag1.repository")
public class RootConfig {

}
