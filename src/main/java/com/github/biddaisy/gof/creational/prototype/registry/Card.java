package com.github.biddaisy.gof.creational.prototype.registry;

import static com.github.biddaisy.gof.Logger.log;

/**
 * Concrete Prototype: Credit/Debit Card.
 */
public class Card extends BankingProduct {

    private final String cardType;
    private final int limit;

    public Card(String cardType, int limit) {
        this.cardType = cardType;
        this.limit = limit;
    }

    @Override
    public void display() {
        log("Card [" + cardType + "], limit=" + limit);
    }
}
