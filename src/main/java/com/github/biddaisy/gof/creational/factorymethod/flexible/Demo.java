package com.github.biddaisy.gof.creational.factorymethod.flexible;

import com.github.biddaisy.gof.Logger;

/**
 * Demonstrates the thread-safe Smalltalk-style Factory Method variant
 * applied to a banking domain.
 *
 * The system can switch between creating BankAccount, Loan, and Card
 * at runtime without subclassing.
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        ConfigurableBankingSystem system =
                new ConfigurableBankingSystem(BankAccount.class);

        // Thread 1: creates products
        Thread t1 = new Thread(() -> {
            BankingProduct p = system.createProduct();
            p.load();
        });

        // Thread 2: reconfigures the product type
        Thread t2 = new Thread(() -> {
            system.setProductClass(Loan.class);
            Logger.log("Switched to Loan");
        });

        // Thread 3: creates products after reconfiguration
        Thread t3 = new Thread(() -> {
            BankingProduct p = system.createProduct();
            p.load();
        });

        t1.start();
        t2.start();
        Thread.sleep(10);
        t3.start();
    }
}
