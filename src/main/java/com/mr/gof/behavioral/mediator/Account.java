package com.mr.gof.behavioral.mediator;

public class Account {

  private final String number;
  private final Currency currency;
  private final Bank bank;

  public Account(String number, Currency currency, Bank bank) {
    this.number = number;
    this.currency = currency;
    this.bank = bank;
  }

  public String getNumber() {
    return number;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Bank getBank() {
    return bank;
  }
}
