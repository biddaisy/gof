package com.mr.gof.structural.decorator.bank;

import com.mr.gof.Logger;

/**
 * Concrete Component.
 * A simple savings account implementation.
 */
public class SavingsAccount implements BankAccount {

    private double balance;

    public SavingsAccount(double initialBalance) {
        this.balance = initialBalance;
        Logger.log("SavingsAccount created with initial balance: {0}", initialBalance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        Logger.debug("Deposited {0}, new balance: {1}", amount, balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        Logger.debug("Withdrew {0}, new balance: {1}", amount, balance);
    }

    @Override
    public double getBalance() {
        return balance;
    }
}
