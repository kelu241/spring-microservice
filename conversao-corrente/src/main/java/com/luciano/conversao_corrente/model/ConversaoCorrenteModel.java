package com.luciano.conversao_corrente.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Conversao_corrente")
public class ConversaoCorrenteModel {
  @Id
  private Long id;
  @Column(name = "from_conversion")
  private String from;
  @Column(name = "to_conversion")
  private String to;
  private BigDecimal quantity;
  private BigDecimal correntMultiple;

  public BigDecimal getCorrentMultiple() {
    return correntMultiple;
  }

  public void setCorrentMultiple(BigDecimal correntMultiple) {
    this.correntMultiple = correntMultiple;
  }

  @Column(name = "port")
  private String enviroment;

  public ConversaoCorrenteModel(Long id, String from, String to, BigDecimal quantity, BigDecimal correntMultiple,
      String enviroment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.quantity = quantity;
    this.enviroment = enviroment;
    this.correntMultiple = correntMultiple;
  }

  public ConversaoCorrenteModel(Long id, String from, String to, BigDecimal quantity, String enviroment) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.quantity = quantity;
    this.enviroment = enviroment;
  }

  public String getEnviroment() {
    return enviroment;
  }

  public void setEnviroment(String enviroment) {
    this.enviroment = enviroment;
  }

  public ConversaoCorrenteModel(Long id, String from, BigDecimal quantity, String to) {
    this.id = id;
    this.from = from;
    this.quantity = quantity;
    this.to = to;
  }

  public ConversaoCorrenteModel() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public BigDecimal getQuantity() {
    return quantity;
  }

  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
  }

}
