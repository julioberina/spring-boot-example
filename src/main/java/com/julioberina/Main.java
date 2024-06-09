package com.julioberina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Foo getFoo() {
        return new Foo();
    }

    public static class Foo {
        public String getFoo() {
            return "Foo Customer";
        }
    }
}
