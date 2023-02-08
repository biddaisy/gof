package com.mr.gof.structural.bridge.bank.card;

import com.mr.gof.structural.bridge.bank.account.Account;
import com.mr.gof.structural.bridge.bank.Currency;
import com.mr.gof.structural.bridge.bank.ExchangeRates;
import com.mr.gof.structural.bridge.bank.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class BasicCard implements Card {

  private final String number;

  private final Person owner;

  private final PaymentSystem paymentSystem;

  private final LocalDate validThru;

  private final Currency cardCurrency;

  private CardStatus cardStatus;

  protected final Account account;

  public BasicCard(String number, Person owner, PaymentSystem paymentSystem, LocalDate validThru, Currency cardCurrency, Account account) {
    this.number = number;
    this.owner = owner;
    this.paymentSystem = paymentSystem;
    this.validThru = validThru;
    this.cardCurrency = cardCurrency;
    this.account = account;
    this.cardStatus = CardStatus.ACTIVE;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public PaymentSystem getPaymentSystem() {
    return paymentSystem;
  }

  @Override
  public Person getOwner() {
    return owner;
  }

  @Override
  public BigDecimal getAvailableBalance() {
    return account.getCurrentBalance();
  }

  @Override
  public void withdraw(BigDecimal amount, Currency currency) {
    if (cardStatus != CardStatus.ACTIVE){
      throw new IllegalStateException("card not active");
    }
    var exchangedAmount = exchange(amount, currency);
    account.transfer(exchangedAmount.negate());
  }

  protected BigDecimal exchange(BigDecimal amount, Currency currency){
    var currency2 = account.getBaseCurrency();
    if (currency == currency2) {
      return amount;
    }
    else {
      var exchangeRate = ExchangeRates.EXCHANGE_RATES.getExchangeRate(currency2, currency);
      return amount.multiply(exchangeRate);
    }
  }

  @Override
  public LocalDate getValidThru() {
    return validThru;
  }

  @Override
  public CardStatus getCardStatus() {
    return cardStatus;
  }

  public void setCardStatus(CardStatus cardStatus) {
    this.cardStatus = cardStatus;
  }

  @Override
  public Currency getCardCurrency() {
    return cardCurrency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BasicCard basicCard)) return false;
    return getNumber().equals(basicCard.getNumber());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getNumber());
  }
}
