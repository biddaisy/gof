package com.mr.gof.structural.decorator.bank;

import com.mr.gof.Logger;

/**
 * Concrete Decorator.
 * Adds logging behavior to account operations.
 */
public class LoggingDecorator extends AccountDecorator {

    public LoggingDecorator(BankAccount account) {
        super(account);
    }

    @Override
    public void deposit(double amount) {
        Logger.log("LOG: Depositing {0}", amount);
        super.deposit(amount);
    }

    @Override
    public void withdraw(double amount) {
        Logger.log("LOG: Withdrawing {0}", amount);
        super.withdraw(amount);
    }
}
