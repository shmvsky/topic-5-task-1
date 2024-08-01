package ru.shmvsky.usingspringdatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UsingSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingSpringDataJpaApplication.class, args);
    }

}
