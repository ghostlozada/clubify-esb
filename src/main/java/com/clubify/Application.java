package com.clubify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring application.
 * @author Gux Lozada.
 */
@EnableJpaRepositories("com.clubify.persistence.repo")
@EntityScan("com.clubify.persistence.modelo")
@SpringBootApplication
public class Application {
    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
