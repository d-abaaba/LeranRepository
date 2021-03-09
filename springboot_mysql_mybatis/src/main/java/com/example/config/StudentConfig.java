package com.example.config;

import com.example.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentConfig {

    @Bean
    public Student getStudent() {
        return new Student(2021, "Lisa",18);
    }
}
