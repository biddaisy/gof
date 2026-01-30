package com.github.biddaisy.gof.creational.factorymethod.flexible;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Product: Loan.
 */
public class Loan implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Loan data...");
    }
}
