package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Autowired
    MsgService msgService;
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
        System.out.println(printSomething());
    }

    @Bean
    public void runIt() {
        msgService.printIt();
    }

    static int printSomething() {
        System.out.println("Something");
        return 1;
    }
}