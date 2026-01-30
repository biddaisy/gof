package com.github.biddaisy.gof.behavioral.mediator;

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

  @Override
  public String toString() {
    return "Account{" + "number='" + number + '\'' + ", currency=" + currency + ", bank=" + bank + '}';
  }
}
