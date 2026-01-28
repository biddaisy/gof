package com.mr.gof.creational.factorymethod.parameterized;

import com.mr.gof.Logger;

public class BankAccount implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading BankAccount data...");
    }
}