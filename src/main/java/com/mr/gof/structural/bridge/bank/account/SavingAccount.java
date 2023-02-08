package com.mr.gof.structural.bridge.bank.account;

import com.mr.gof.structural.bridge.bank.Currency;
import com.mr.gof.structural.bridge.bank.Person;

import java.math.BigDecimal;

public class SavingAccount extends CurrentAccount {

  private BigDecimal withdrawalLimit;

  public SavingAccount(String number, Person owner, Currency baseCurrency, BigDecimal currentBalance, BigDecimal withdrawalLimit) {
    super(number, owner, baseCurrency, currentBalance);
    this.withdrawalLimit = withdrawalLimit;
  }

  @Override
  public void transfer(BigDecimal amount) {
    var updatedWithdrawalLimit = withdrawalLimit.subtract(amount);
    if (updatedWithdrawalLimit.signum() == -1) {
      throw new IllegalArgumentException("Limit exceeded");
    }
    withdrawalLimit = updatedWithdrawalLimit;
    super.transfer(amount);
  }
}
