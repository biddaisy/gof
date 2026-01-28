package com.mr.gof.creational.factorymethod.flexible;

import com.mr.gof.Logger;

/**
 * Concrete Product: Bank Account.
 */
public class BankAccount implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading BankAccount data...");
    }
}
