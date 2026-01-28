package com.mr.gof.creational.factorymethod.parameterized;

import com.mr.gof.Logger;

public class Loan implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Loan data...");
    }
}
