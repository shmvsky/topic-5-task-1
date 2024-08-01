package ru.shmvsky.usinghibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import ru.shmvsky.usinghibernate.entity.Todo;
import ru.shmvsky.usinghibernate.repository.TodoRepository;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class UsingHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsingHibernateApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(TodoRepository todoRepository) {
        return (args) -> {
            System.out.println("It's alive!");

            var todo = new Todo();
            todo.setTitle("Сделать практику по 5 теме");
            todo.setCompleted(false);

            todoRepository.save(todo);
        };
    }

}
