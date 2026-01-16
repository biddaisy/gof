package com.mr.gof.structural.flyweight.bank;

import com.mr.gof.Logger;

import java.math.BigDecimal;

/**
 * Demonstrates Flyweight usage with:
 * - Currency flyweights
 * - Transaction type flyweights
 * - Bank branch flyweights
 */
public class FlyweightBankDemo {
    static void main(String[] args) {

        Logger.log("=== Creating transactions with multiple flyweights ===");

        Transaction t1 = new Transaction(
                "ACC-1001",
                new BigDecimal("150.75"),
                "USD",
                "DEPOSIT",
                "BR-001"
        );

        Transaction t2 = new Transaction(
                "ACC-2002",
                new BigDecimal("99.99"),
                "USD",
                "WITHDRAW",
                "BR-001"
        );

        Transaction t3 = new Transaction(
                "ACC-3003",
                new BigDecimal("5000"),
                "JPY",
                "TRANSFER",
                "BR-003"
        );

        t1.print();
        t2.print();
        t3.print();

        Logger.log("USD flyweight reused: {0}",
                CurrencyFactory.getCurrency("USD") == CurrencyFactory.getCurrency("USD"));

        Logger.log("DEPOSIT type reused: {0}",
                TransactionTypeFactory.get("DEPOSIT") == TransactionTypeFactory.get("DEPOSIT"));

        Logger.log("Branch BR-001 reused: {0}",
                BankBranchFactory.get("BR-001") == BankBranchFactory.get("BR-001"));
    }
}
