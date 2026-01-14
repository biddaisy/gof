package com.mr.gof.structural.decorator.bank;

import com.mr.gof.Logger;

/**
 * Concrete Decorator.
 * Adds a fixed service fee to every withdrawal.
 */
public class FeeDecorator extends AccountDecorator {

    private static final double FEE = 1.50;

    public FeeDecorator(BankAccount account) {
        super(account);
    }

    @Override
    public void withdraw(double amount) {
        Logger.log("Applying service fee of {0}", FEE);
        super.withdraw(amount + FEE);
    }
}
