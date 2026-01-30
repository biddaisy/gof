package com.github.biddaisy.gof.structural.flyweight.bank;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Factory ensuring reuse of TransactionType flyweights.
 */
public class TransactionTypeFactory {

    private static final Map<String, TransactionTypeFlyweight> CACHE = new ConcurrentHashMap<>();

    private TransactionTypeFactory() {
    }

    public static TransactionTypeFlyweight get(String code) {
        return CACHE.computeIfAbsent(code, TransactionTypeFactory::create);
    }

    private static TransactionTypeFlyweight create(String code) {
        return switch (code) {
            case "DEPOSIT" -> new TransactionType("DEPOSIT", "Account deposit", false);
            case "WITHDRAW" -> new TransactionType("WITHDRAW", "Account withdrawal", false);
            case "TRANSFER" -> new TransactionType("TRANSFER", "Account-to-account transfer", true);
            case "LOAN_PAY" -> new TransactionType("LOAN_PAY", "Loan repayment", true);
            default -> throw new IllegalArgumentException("Unknown transaction type: " + code);
        };
    }
}
