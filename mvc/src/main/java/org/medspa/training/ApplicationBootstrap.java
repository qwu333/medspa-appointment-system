package org.medspa.training;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"org.medspa.training"})
@ServletComponentScan(basePackages = {"org.medspa.training.filter"})
public class ApplicationBootstrap extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(ApplicationBootstrap.class, args);
    }
}