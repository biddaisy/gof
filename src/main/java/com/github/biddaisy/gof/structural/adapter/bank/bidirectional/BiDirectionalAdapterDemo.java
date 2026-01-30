package com.github.biddaisy.gof.structural.adapter.bank.bidirectional;

import com.github.biddaisy.gof.Logger;

import java.math.BigDecimal;

/**
 * Demonstrates both directions of the bi-directional adapter.
 */
public class BiDirectionalAdapterDemo {

    static void main() {

        BiDirectionalBankAdapter adapter = new BiDirectionalBankAdapter();

        // Modern system calling legacy operations
        BankAccountService modern = adapter;
        Logger.log("Modern → Balance: " + modern.getBalance("ACC-1001"));
        modern.deposit("ACC-1001", new BigDecimal("200.00"));
        modern.withdraw("ACC-1001", new BigDecimal("50.00"));

        // Legacy system calling modern operations
        LegacyBankingOperations legacy = adapter;
        Logger.log("Legacy → Balance: " + legacy.fetchBalance("ACC-1001"));
        legacy.makeDeposit("ACC-1001", new BigDecimal("300.00"));
        legacy.makeWithdrawal("ACC-1001", new BigDecimal("100.00"));
    }
}
