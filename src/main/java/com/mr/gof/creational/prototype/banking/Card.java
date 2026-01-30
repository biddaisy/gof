package com.mr.gof.creational.prototype.banking;

import static com.mr.gof.Logger.log;

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
