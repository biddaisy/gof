package com.mr.gof.structural.decorator.bank;

import com.mr.gof.Logger;

/**
 * Concrete Decorator.
 * Adds simple fraud detection rules.
 */
public class FraudCheckDecorator extends AccountDecorator {

    public FraudCheckDecorator(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 5000) {
            Logger.warn("FRAUD ALERT: Large withdrawal attempt: {0}", amount);
        }
        super.withdraw(amount);
    }
}
