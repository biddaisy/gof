package com.mr.gof.creational.factorymethod.parameterized;

import com.mr.gof.Logger;

public class Card implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Card data...");
    }
}
