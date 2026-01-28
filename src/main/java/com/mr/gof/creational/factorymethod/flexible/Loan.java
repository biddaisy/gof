package com.mr.gof.creational.factorymethod.flexible;

import com.mr.gof.Logger;

/**
 * Concrete Product: Loan.
 */
public class Loan implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Loan data...");
    }
}
