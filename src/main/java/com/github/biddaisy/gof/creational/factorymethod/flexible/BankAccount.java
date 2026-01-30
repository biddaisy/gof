package com.github.biddaisy.gof.creational.factorymethod.flexible;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Product: Bank Account.
 */
public class BankAccount implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading BankAccount data...");
    }
}
