package com.github.biddaisy.gof.structural.flyweight.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory that ensures only one CurrencyFlyweight exists per currency code.
 */
public class CurrencyFactory {

    private static final Map<String, CurrencyFlyweight> CACHE = new ConcurrentHashMap<>();

    private CurrencyFactory() {
    }

    public static CurrencyFlyweight getCurrency(String code) {
        return CACHE.computeIfAbsent(code, CurrencyFactory::createCurrency);
    }

    private static CurrencyFlyweight createCurrency(String code) {
        return switch (code) {
            case "USD" -> new Currency("USD", "$", 2, "United States");
            case "EUR" -> new Currency("EUR", "€", 2, "European Union");
            case "JPY" -> new Currency("JPY", "¥", 0, "Japan");
            default -> throw new IllegalArgumentException("Unsupported currency: " + code);
        };
    }
}
