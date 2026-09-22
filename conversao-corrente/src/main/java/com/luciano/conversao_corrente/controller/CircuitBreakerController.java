package com.luciano.conversao_corrente.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import io.github.resilience4j.retry.annotation.Retry;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitBreakerController {

  private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);
  @Retry(name = "circuit-api", fallbackMethod = "hardcodeResponse")
  @GetMapping("/circuit-api/")
  @Bulkhead(name = "circuit-api", type = Bulkhead.Type.THREADPOOL, fallbackMethod = "hardcodeResponse")
  @CircuitBreaker(name = "circuit-api", fallbackMethod = "hardcodeResponse")
  public String circuitApi() {
    logger.info("Circuit foi chamada biscoito");
    throw new RuntimeException("Erro forçado para testar o circuit breaker");

  }

  public String hardcodeResponse(Throwable ex) {
    logger.error("Fallback acionado", ex);
    return "Deu merda?...";
  }

}
