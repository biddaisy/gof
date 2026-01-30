package com.github.biddaisy.gof.structural.flyweight.bank;

/**
 * Flyweight interface representing shared currency metadata.
 */
public interface CurrencyFlyweight {
    String code();
    String symbol();
    int decimals();
    String country();
}
