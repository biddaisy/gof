package com.mr.gof.creational.prototype.banking;

import static com.mr.gof.Logger.log;

/**
 * Concrete Prototype: Bank Account.
 *
 * Instead of separate classes for CheckingAccount, SavingsAccount, etc.,
 * we use one class with configurable fields.
 */
public class BankAccount extends BankingProduct {

    private final String accountType;
    private final double interestRate;

    public BankAccount(String accountType, double interestRate) {
        this.accountType = accountType;
        this.interestRate = interestRate;
    }

    @Override
    public void display() {
        log("BankAccount [" + accountType + "], interest=" + interestRate);
    }
}
