package com.github.biddaisy.gof.structural.adapter.bank;

import java.math.BigDecimal;

/**
 * Target interface expected by the modern parameterized system.
 * <p>
 * This interface defines clean, domain‑friendly operations for
 * interacting with bank accounts. New services, microservices,
 * and REST controllers depend on this abstraction.
 */
public interface BankAccountService {

    /**
     * Returns the current balance for the given account.
     */
    BigDecimal getBalance(String accountId);

    /**
     * Deposits the specified amount into the account.
     */
    void deposit(String accountId, BigDecimal amount);

    /**
     * Withdraws the specified amount from the account.
     */
    void withdraw(String accountId, BigDecimal amount);
}
