package org.example.relations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"org.example"})
@ComponentScan(basePackages = {"org.example"})
@EnableJpaRepositories(basePackages = {"org.example"})
public class RelationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(RelationsApplication.class, args);
    }
}
