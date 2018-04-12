package com.siwoo.webappag1;

import com.siwoo.webappag1.converter.JsonLocalDateTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.converter.cbor.MappingJackson2CborHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Profile("prod")
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Bean
    InternalResourceViewResolver viewResolver() {
        return new InternalResourceViewResolver("/static/",".html");
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").setCachePeriod(0);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/").setCachePeriod(0);
    }
}
