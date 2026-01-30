package com.github.biddaisy.gof.structural.decorator.bank;

/**
 * Base Decorator.
 * Wraps a BankAccount and delegates all operations to it.
 * Subclasses extend behavior without modifying the wrapped object.
 */
public abstract class AccountDecorator implements BankAccount {

    protected final BankAccount account;

    protected AccountDecorator(BankAccount account) {
        this.account = account;
    }

    @Override
    public void deposit(double amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    @Override
    public double getBalance() {
        return account.getBalance();
    }
}
