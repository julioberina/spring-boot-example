package com.julioberina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse(
                "John",
                List.of("Java", "TypeScript", "Go"),
                new Person(
                        "John Doe",
                        26,
                        "Software Engineer"
                )
        );
    }

    public record GreetResponse(
            String greeted,
            List<String> programmingLanguages,
            Person person
    ) {}

    public record Person(
            String name,
            int age,
            String occupation
    ) {}
}
