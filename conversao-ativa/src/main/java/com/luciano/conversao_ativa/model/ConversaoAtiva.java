
package com.luciano.conversao_ativa.model;

import java.math.BigDecimal;

public class ConversaoAtiva {
  private Long id;
  private String from;
  private String to;
  private BigDecimal quantity;
  private String enviroment;
  private BigDecimal conversionMultiple;
  private BigDecimal totalCalculatedAmount;

  public ConversaoAtiva(Long id, String from, String to, BigDecimal quantity2, String enviroment,
      BigDecimal conversionMultiple, BigDecimal totalCalculatedAmount) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.quantity = quantity2;
    this.enviroment = enviroment;
    this.conversionMultiple = conversionMultiple;
    this.totalCalculatedAmount = totalCalculatedAmount;
  }

  public BigDecimal getConversionMultiple() {
    return conversionMultiple;
  }

  public void setConversionMultiple(BigDecimal conversionMultiple) {
    this.conversionMultiple = conversionMultiple;
  }

  public BigDecimal getTotalCalculatedAmount() {
    return totalCalculatedAmount;
  }

  public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
    this.totalCalculatedAmount = totalCalculatedAmount;
  }

  public ConversaoAtiva(Long id, String from, String to, BigDecimal quantity, String enviroment) {
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

  public ConversaoAtiva(Long id, String from, BigDecimal quantity, String to) {
    this.id = id;
    this.from = from;
    this.quantity = quantity;
    this.to = to;
  }

  public ConversaoAtiva() {
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
