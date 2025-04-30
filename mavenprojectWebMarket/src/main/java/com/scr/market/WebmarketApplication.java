package com.scr.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan ({"com.scr.market","com.scr.market.repository", "com.scr.market.service"})
@SpringBootApplication(scanBasePackages={
"com.scr.market","com.scr.market.repository", "com.scr.market.service"})
public class WebmarketApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebmarketApplication.class.getName());


    public static void main(String[] args) {
        LOGGER.info("main  start");
        SpringApplication.run(WebmarketApplication.class, args);
    }

}
