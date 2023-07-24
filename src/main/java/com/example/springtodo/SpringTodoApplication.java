package com.example.springtodo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.springtodo")
@OpenAPIDefinition(
    info =
        @Info(
            title = "EmployeeEntity Management Project",
            version = "1.0.0",
            description = "Anh Khoa cho em 10 diem nhan"))
public class SpringTodoApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringTodoApplication.class, args);
  }
}
