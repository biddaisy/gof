package com.mr.gof.structural.decorator.bank;

/**
 * Component interface in the Decorator pattern.
 * Represents a generic bank account with basic operations.
 */
public interface BankAccount {

    /** Deposit money into the account. */
    void deposit(double amount);

    /** Withdraw money from the account. */
    void withdraw(double amount);

    /** Retrieve the current balance. */
    double getBalance();
}

