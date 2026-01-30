package com.github.biddaisy.gof.structural.proxy.bank;

import java.math.BigDecimal;

/**
 * Subject interface for bank account operations.
 */
public interface BankAccountService {
    void deposit(String accountId, BigDecimal amount);
    void withdraw(String accountId, BigDecimal amount);
    BigDecimal getBalance(String accountId);
}
