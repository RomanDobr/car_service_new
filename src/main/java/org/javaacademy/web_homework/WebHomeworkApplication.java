package org.javaacademy.web_homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WebHomeworkApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(WebHomeworkApplication.class, args);
  }
}
