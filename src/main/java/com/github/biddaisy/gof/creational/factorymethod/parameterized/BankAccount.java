package com.github.biddaisy.gof.creational.factorymethod.parameterized;

import com.github.biddaisy.gof.Logger;

public class BankAccount implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading BankAccount data...");
    }
}