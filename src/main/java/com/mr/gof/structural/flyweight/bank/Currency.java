package com.mr.gof.structural.flyweight.bank;

/**
 * Immutable flyweight object containing intrinsic currency data.
 */
public record Currency(String code, String symbol, int decimals, String country) implements CurrencyFlyweight {
}
