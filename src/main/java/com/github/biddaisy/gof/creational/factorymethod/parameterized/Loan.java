package com.github.biddaisy.gof.creational.factorymethod.parameterized;

import com.github.biddaisy.gof.Logger;

public class Loan implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Loan data...");
    }
}
