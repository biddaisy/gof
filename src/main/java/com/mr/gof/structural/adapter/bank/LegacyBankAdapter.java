package com.mr.gof.structural.adapter.bank;

import java.math.BigDecimal;

/**
 * Adapter: Converts the modern BankAccountService interface
 * into calls to the legacy core parameterized API.
 * <p>
 * This allows new code to interact with the old system
 * without modifying the legacy implementation.
 */
public class LegacyBankAdapter implements BankAccountService {

    private final LegacyCoreBankingAPI legacy;

    /**
     * Inject the legacy API instance.
     */
    public LegacyBankAdapter(LegacyCoreBankingAPI legacy) {
        this.legacy = legacy;
    }

    /**
     * Maps the modern getBalance() call to the legacy fetchBalance().
     */
    @Override
    public BigDecimal getBalance(String accountId) {
        return legacy.fetchBalance(accountId);
    }

    /**
     * Maps the modern deposit() call to the legacy makeDeposit().
     */
    @Override
    public void deposit(String accountId, BigDecimal amount) {
        legacy.makeDeposit(accountId, amount);
    }

    /**
     * Maps the modern withdraw() call to the legacy makeWithdrawal().
     */
    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        legacy.makeWithdrawal(accountId, amount);
    }
}
