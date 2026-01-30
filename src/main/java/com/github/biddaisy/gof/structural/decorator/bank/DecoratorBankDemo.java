package com.github.biddaisy.gof.structural.decorator.bank;

import com.github.biddaisy.gof.Logger;

/**
 * Demonstrates the Decorator pattern applied to a parameterized domain.
 * Decorators are stacked to add multiple behaviors dynamically.
 */
public class DecoratorBankDemo {

    private DecoratorBankDemo() {
    }

    static void main() {

        // Build a decorated account:
        // SavingsAccount → FeeDecorator → FraudCheckDecorator → LoggingDecorator
        BankAccount account =
                new LoggingDecorator(
                        new FraudCheckDecorator(
                                new FeeDecorator(
                                        new SavingsAccount(10_000)
                                )
                        )
                );

        Logger.log("=== Starting operations ===");

        account.deposit(500);
        account.withdraw(6000);

        Logger.log("Final balance: {0}", account.getBalance());
    }
}
