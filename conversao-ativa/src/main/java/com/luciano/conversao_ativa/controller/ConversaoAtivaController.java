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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.luciano.conversao_ativa.feign_clients.ConversaoAtivaProxy;
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
  @Autowired
  private ConversaoAtivaProxy conversaoAtivaProxy;

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

    if (conversaoAtiva == null || conversaoAtiva.getConversionMultiple() == null) {
      throw new ResponseStatusException(HttpStatus.BAD_GATEWAY,
          "Resposta invalida do servico de conversao de corrente");
    }

    return new ConversaoAtiva(
        conversaoAtiva.getId(),
        from,
        to,
        quantity,
        conversaoAtiva.getEnviroment(),
        conversaoAtiva.getConversionMultiple(),
        quantity.multiply(conversaoAtiva.getConversionMultiple()));

  }

  @GetMapping("feign/ativa/from/{from}/to/{to}/quantity/{quantity}")
  public ConversaoAtiva conversaoAtivaFeign(@PathVariable String from, @PathVariable String to,
      @PathVariable BigDecimal quantity) {

    ConversaoAtiva conversaoAtiva = conversaoAtivaProxy.conversaoAtivaPegaValor(from, to);

    return new ConversaoAtiva(conversaoAtiva.getId(),
        from,
        to,
        quantity,
        conversaoAtiva.getEnviroment() + " feign",
        conversaoAtiva.getConversionMultiple(),
        quantity.multiply(conversaoAtiva.getConversionMultiple()));

  }

}
