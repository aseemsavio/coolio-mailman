package com.coolio.mailman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoolioMailmanApplication{

    public static void main(String[] args) {
        SpringApplication.run(CoolioMailmanApplication.class, args);
    }
}
