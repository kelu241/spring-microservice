package com.luciano.apigateway.log;

import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

import java.time.LocalDate;

import org.slf4j.Logger;

@Component
public class Log implements GlobalFilter {

  private final Logger logger = LoggerFactory.getLogger(Log.class);

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    logger.info("=============================================================================");
    logger.info("Caminho da requisição recebida olhe aqui biscoito -> {} na data {}",
        exchange.getRequest().getPath(), LocalDate.now());
    logger.info("=============================================================================");
    return chain.filter(exchange);
  }
}
