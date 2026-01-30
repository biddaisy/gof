package com.github.biddaisy.gof.creational.factorymethod.flexible;

import com.github.biddaisy.gof.Logger;

/**
 * Concrete Product: Card.
 */
public class Card implements BankingProduct {
    @Override
    public void load() {
        Logger.log("Loading Card data...");
    }
}
