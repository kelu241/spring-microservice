package com.luciano.conversao_ativa.feign_clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.luciano.conversao_ativa.model.ConversaoAtiva;

@FeignClient(name = "conversao-corrente")
public interface ConversaoAtivaProxy {
  @GetMapping("/corrente/conversao-corrente/from/{from}/to/{to}")
  public ConversaoAtiva conversaoAtivaPegaValor(@PathVariable String from, @PathVariable String to);
}
