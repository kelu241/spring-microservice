
package com.luciano.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfiguration {

  @Bean
  public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

    return builder.routes()
        .route(
            p -> p.path("/get")
                .filters(f -> f.addRequestHeader("MyHeader", "MyURI")
                    .addRequestParameter("Param", "MyValue"))
                .uri("http://httpbin.org:80"))
        .route(p -> p.path("/activa/**")
            .filters(f -> f.rewritePath("/activa/(?<segment>.*)",
                "/feign/ativa/${segment}"))
            .uri("lb://CONVERSAO-ATIVA"))
        .route(p -> p.path("/biscoito/**")
            .filters(f -> f.rewritePath("/biscoito/(?<pedacoUrl>.*)",
                "/ativa/${pedacoUrl}"))
            .uri("lb://CONVERSAO-ATIVA"))
        .build();

  }

}
