package com.luciano.conversao_ativa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConversaoAtivaApplication {

  public static void main(String[] args) {
    SpringApplication.run(ConversaoAtivaApplication.class, args);
  }

}
