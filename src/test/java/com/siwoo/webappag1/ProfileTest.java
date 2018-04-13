package com.siwoo.webappag1;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static junit.framework.TestCase.assertNotNull;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class ProfileTest {

    @Autowired
    DataSource dataSource;
    @Autowired
    Environment environment;

    @Test
    public void test() {
        log.warn("#######system property: " + System.getProperty("spring.profiles.active"));
        log.warn("#######environment property: " + environment.getProperty("spring.profiles.active"));
        assertNotNull(dataSource);
    }
}
