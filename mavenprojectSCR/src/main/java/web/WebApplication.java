package web;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan ({"web","web.service", "web.repository"})
@SpringBootApplication(scanBasePackages={
"web", "web.repository", "web.service"})
public class WebApplication extends SpringBootServletInitializer {

    @Override
    // Configuring method has to be overridden    
    protected SpringApplicationBuilder
            configure(SpringApplicationBuilder application) {
        return application.sources(
                WebApplication.class);
    }

    // Method 2    
    // Main driver method    
    public static void main(String[] args) {
        SpringApplication.run(
                WebApplication.class,
                args);
    }

}
