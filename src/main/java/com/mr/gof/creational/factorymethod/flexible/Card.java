package com.mr.gof.creational.factorymethod.flexible;

import com.mr.gof.Logger;

/**
 * Concrete Product: Card.
 */
public class Card implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Card data...");
    }
}
