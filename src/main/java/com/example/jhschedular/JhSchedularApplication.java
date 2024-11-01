package com.example.jhschedular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class JhSchedularApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhSchedularApplication.class, args);
    }

}
