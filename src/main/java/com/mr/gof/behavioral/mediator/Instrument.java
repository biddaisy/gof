package com.mr.gof.behavioral.mediator;

import java.util.List;

public class Instrument {

  private final Account orderingAccount;

  private final List<Currency> transferCurrencies;

  private final Country beneficiaryCountry;

  private final ServiceLevel serviceLevel;

  public Instrument(Account orderingAccount, List<Currency> transferCurrencies, Country beneficiaryCountry, ServiceLevel serviceLevel) {
    this.orderingAccount = orderingAccount;
    this.transferCurrencies = transferCurrencies;
    this.beneficiaryCountry = beneficiaryCountry;
    this.serviceLevel = serviceLevel;
  }

  public Account getOrderingAccount() {
    return orderingAccount;
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
