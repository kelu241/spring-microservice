package com.luciano.conversao_corrente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luciano.conversao_corrente.model.ConversaoCorrenteModel;
import com.luciano.conversao_corrente.repository.ConversaoCorrenteRepository;

@RestController
@RequestMapping("/corrente")

public class ConversaoCorrenteController {
  @Autowired
  private Environment enviroment;
  @Autowired
  private ConversaoCorrenteRepository jpa;

  @GetMapping("/conversao-corrente/from/{from}/to/{to}")
  public ConversaoCorrenteModel resgatarValorTrocado(@PathVariable String from, @PathVariable String to) {
    ConversaoCorrenteModel conversaoCorrenteModel = jpa.findByFromAndTo(from, to);

    if (conversaoCorrenteModel == null) {

      throw new RuntimeException("Deu merda para encontrar data " + from + "e" + to);

    }

    String port = enviroment.getProperty("local.server.port");

    conversaoCorrenteModel.setEnviroment(port);

    return conversaoCorrenteModel;

  }

}
