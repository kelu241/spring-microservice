package com.luciano.conversao_corrente.repository;

import org.springframework.data.repository.Repository;

import com.luciano.conversao_corrente.model.ConversaoCorrenteModel;

public interface ConversaoCorrenteRepository extends Repository<ConversaoCorrenteModel, Long> {
  ConversaoCorrenteModel findByFromAndTo(String from, String to);

}
