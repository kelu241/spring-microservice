package com.luciano.conversao_ativa.controller;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.luciano.conversao_ativa.model.ConversaoAtiva;

@Configuration(proxyBeanMethods = false)
class ConfigurerRestClient {
  @Bean
  public RestClient restClient(RestClient.Builder builder) {
    return builder.build();
  }

}

@RestController
public class ConversaoAtivaController {
  @Autowired
  private RestClient restClient;

  @GetMapping("/ativa/from/{from}/to/{to}/quantity/{quantity}")
  public ConversaoAtiva conversaoAtiva(@PathVariable String from, @PathVariable String to,
      @PathVariable BigDecimal quantity) {

    HashMap<String, String> urlValues = new HashMap<>();

    urlValues.put("from", from);
    urlValues.put("to", to);

    ConversaoAtiva conversaoAtiva = restClient.get()
        .uri("http://localhost:8000/corrente/conversao-corrente/from/{from}/to/{to}", urlValues)
        .retrieve()
        .body(ConversaoAtiva.class);

    return new ConversaoAtiva(
        conversaoAtiva.getId(),
        from,
        to,
        quantity,
        conversaoAtiva.getEnviroment(),
        conversaoAtiva.getConversionMultiple(),
        conversaoAtiva.getConversionMultiple().multiply(conversaoAtiva.getConversionMultiple()));

  }

}
