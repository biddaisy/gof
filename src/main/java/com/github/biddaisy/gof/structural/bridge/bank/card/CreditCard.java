package com.github.biddaisy.gof.structural.bridge.bank.card;

import com.github.biddaisy.gof.structural.bridge.bank.account.Account;
import com.github.biddaisy.gof.structural.bridge.bank.Currency;
import com.github.biddaisy.gof.structural.bridge.bank.Person;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCard extends BasicCard {

  private final BigDecimal limit;

  public CreditCard(String number, Person owner, PaymentSystem paymentSystem, LocalDate validThru, Account account, BigDecimal limit) {
    super(number, owner, paymentSystem, validThru, account);
    this.limit = limit;
  }

  @Override
  public void withdraw(BigDecimal amount, Currency currency) {
    var exchangedAmount = exchange(amount, currency);
    var currentBalance = account.getCurrentBalance();
    var updatedBalance = currentBalance.subtract(exchangedAmount);
    if (limit.subtract(updatedBalance.negate()).signum() == -1) {
      throw new IllegalArgumentException("Not enough limit");
    }
    super.withdraw(exchangedAmount, account.getBaseCurrency());
  }

  @Override
  public BigDecimal getAvailableBalance() {
    return super.getAvailableBalance().add(limit);
  }
}
