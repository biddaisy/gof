package com.mr.gof.structural.adapter.bank.classadapter;

import java.math.BigDecimal;

/**
 * Class Adapter version of the Adapter Pattern.
 *
 * Uses inheritance instead of composition:
 * - Extends the legacy API directly
 * - Implements the modern BankAccountService interface
 */
public class LegacyBankClassAdapter
        extends LegacyCoreBankingAPI
        implements BankAccountService {

    @Override
    public BigDecimal getBalance(String accountId) {
        return fetchBalance(accountId);
    }

    @Override
    public void deposit(String accountId, BigDecimal amount) {
        makeDeposit(accountId, amount);
    }

    @Override
    public void withdraw(String accountId, BigDecimal amount) {
        makeWithdrawal(accountId, amount);
    }
}
