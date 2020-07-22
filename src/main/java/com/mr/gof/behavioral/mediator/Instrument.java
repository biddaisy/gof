package com.mr.gof.behavioral.mediator;

import java.util.List;

public class Instrument {

  private final Bank bank;

  private final List<Currency> transferCurrencies;

  private final Country beneficiaryCountry;

  private final ServiceLevel serviceLevel;

  public Instrument(Bank bank, List<Currency> transferCurrencies, Country beneficiaryCountry, ServiceLevel serviceLevel) {
    this.bank = bank;
    this.transferCurrencies = transferCurrencies;
    this.beneficiaryCountry = beneficiaryCountry;
    this.serviceLevel = serviceLevel;
  }

  public Bank getBank() {
    return bank;
  }

  public List<Currency> getTransferCurrencies() {
    return transferCurrencies;
  }

  public Country getBeneficiaryCountry() {
    return beneficiaryCountry;
  }

  public ServiceLevel getServiceLevel() {
    return serviceLevel;
  }
}
