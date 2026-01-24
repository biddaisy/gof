package com.mr.gof.structural.adapter.bank.bidirectional;

import java.math.BigDecimal;

/**
 * Bi-directional adapter that allows:
 * - Modern systems to call legacy operations
 * - Legacy systems to call modern operations
 *
 * This is useful during gradual migration where both systems
 * must interoperate without being rewritten.
 */
public class BiDirectionalBankAdapter
        implements BankAccountService, LegacyBankingOperations {

    private BigDecimal balance = new BigDecimal("1000.00");

    // -----------------------------
    // Modern → Legacy direction
    // -----------------------------

    @Override
    public BigDecimal getBalance(String accountId) {
        return fetchBalance(accountId); // delegate to legacy-style method
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        makeDeposit(accountId, amount);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        makeWithdrawal(accountId, amount);
    }

    // -----------------------------
    // Legacy → Modern direction
    // -----------------------------

    @Override
    public BigDecimal fetchBalance(String acct) {
        return balance;
    }

    @Override
    public void makeDeposit(String acct, BigDecimal amt) {
        balance = balance.add(amt);
        System.out.println("[ADAPTER] Deposit: +" + amt + " → New balance: " + balance);
    }

    @Override
    public void makeWithdrawal(String acct, BigDecimal amt) {
        balance = balance.subtract(amt);
        System.out.println("[ADAPTER] Withdrawal: -" + amt + " → New balance: " + balance);
    }
}
